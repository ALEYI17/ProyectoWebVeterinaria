package com.vetcare.proyecto.controlador;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetcare.proyecto.Exepciones.NotFoundException;
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.entities.Tratamiento;
import com.vetcare.proyecto.service.ClienteServicio;
import com.vetcare.proyecto.service.MascotaServicio;



@RestController
@RequestMapping("/Mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    MascotaServicio  mascotaServicio;

    @Autowired
    ClienteServicio clienteServicio;

    // Mostrar todas las mascotas
    // http://localhost:8090/Mascota/todas
    @GetMapping("/todas")
    public ResponseEntity<List<Mascota>> MostrarMascotas(){

        List<Mascota> lista = mascotaServicio.GetAll();

        ResponseEntity<List<Mascota>> response = new ResponseEntity<>(lista, HttpStatus.OK);
        
        return response;
    }

    // Mostrar una mascota por su ID usando el parámetro de solicitud
    //http://localhost:8090/Mascota/find/id
    @GetMapping("/find")
    public Mascota MostrarMascotaXId(Model model, @RequestParam("id") Long id){
        Mascota mascota = mascotaServicio.GetById(id);
        if(mascota != null){
            //model.addAttribute("Mascota", mascota);
        } 
        else{
            throw new NotFoundException(id);
        }
        return mascota;
    }

    // Mostrar una mascota por su ID usando una variable de ruta
    //http://localhost:8090/Mascota/find/id
    @GetMapping("find/{id}")
    public ResponseEntity<Mascota> mostrarInfoMascota2(Model model, @PathVariable("id") Long id){
        Mascota mascota = mascotaServicio.GetById(id);
        
        if(mascota != null){
            ResponseEntity<Mascota> reponse = new ResponseEntity<Mascota>(mascota, HttpStatus.OK);
            return reponse;
            
        }
        else{
            ResponseEntity<Mascota> reponse = new ResponseEntity<Mascota>(mascota, HttpStatus.NOT_FOUND);
            return reponse;
        }

    }

    // retorna el id del dueno de la mascota
    //http://localhost:8090/Mascota/find/id/dueno
    @GetMapping("find/{id}/dueno")
    public Long mostrarInfoMascotaConDueno( @PathVariable("id") Long id){
        Mascota mascota = mascotaServicio.GetById(id);
        if(mascota != null){
            Cliente dueno = mascota.getCliente();
            
            if(dueno != null){
                return dueno.getId();
            }
            
        }
       else{
            throw new NotFoundException(id);
        }

        return 1L;
    }
    
    //agrega una mascota 
    //http://localhost:8090/Mascota/agregar
    @PostMapping("/agregar")
    public ResponseEntity<Mascota> agregarmascota(@RequestBody Mascota mascota, @RequestParam("clientId") String clientId){

        Cliente duenno = clienteServicio.GetById(Long.valueOf(clientId));
        if(duenno != null){
            mascota.setCliente(duenno);
        }

        Mascota mascotaAgregada = mascotaServicio.addMascota(mascota);
        if(mascotaAgregada == null){
            ResponseEntity<Mascota> reponse = new ResponseEntity<Mascota>(mascotaAgregada, HttpStatus.BAD_REQUEST);
            return reponse;
        }

        ResponseEntity<Mascota>  reponse = new ResponseEntity<Mascota>(mascotaAgregada, HttpStatus.CREATED);
        return reponse;


    }

    //http://localhost:8090/Mascota/delete/{id}
    // Eliminar una mascota por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable("id") Long id ){
        mascotaServicio.removeMascota(id);
        return new ResponseEntity<>("DELETED",HttpStatus.NO_CONTENT);
    }

    //http://localhost:8090/Mascota/update/{id}
    // Actualizar una mascota
    @PutMapping("/update/{id}")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable("id") Long id, 
                                     @RequestBody Mascota mascota,
                                     @RequestParam("cliente.id") String clienteId){

        Cliente duenno = clienteServicio.GetById(Long.parseLong(clienteId));
        if (duenno != null) {
            mascota.setCliente(duenno);
        }
        Mascota mascotaUpdate = mascotaServicio.updateMascota(mascota);
        if(mascotaUpdate == null){
            ResponseEntity<Mascota> reponse = new ResponseEntity<Mascota>(mascotaUpdate, HttpStatus.NOT_FOUND);
            return reponse;
        }

        ResponseEntity<Mascota> reponse = new ResponseEntity<Mascota>(mascotaUpdate, HttpStatus.OK);
        return reponse;
       
    }

    //http://localhost:8090/Mascota/find/{id}/duenocompleto
    // Consigue el dueño de la mascota
    @GetMapping("find/{id}/duenocompleto")
        public Cliente mostrarInfoMascotaConDuenoCompleto( @PathVariable("id") Long id){
        Mascota mascota = mascotaServicio.GetById(id);
        if(mascota != null){
            Cliente dueno = mascota.getCliente();
            
            if(dueno != null){
                return dueno;
            }
            
        }
       else{
            throw new NotFoundException(id);
        }

        return null;
    }

    //http://localhost:8090/Mascota/find/{id}/tratamientos
    // Consigue los tratamientos de la mascota
    @GetMapping("find/{id}/tratamientos")
    public List<Tratamiento> mostrarTratamientosDeMascota(@PathVariable("id") Long id){
        Mascota mascota = mascotaServicio.GetById(id);
        if(mascota!= null){
            List<Tratamiento> tratamientos = mascota.getTratamientos();
            if(tratamientos != null){
                return tratamientos;
            }
        }
        else{
            throw new NotFoundException(id);
        }
        return null;
    }

    //http://localhost:8090/Mascota/cambiarestado/{id}
    @PutMapping("cambiarestado/{id}")
    public Boolean cambiarEstadoMascota(@PathVariable("id") Long id, @RequestBody Boolean estado){
        log.info("ID mascota"+id.toString());
        log.info("estado mascota"+ estado.toString());
        Mascota cambioMascota = mascotaServicio.GetById(id);
        if (cambioMascota.getTratamientos().size() == 0){
            log.info("Se retorna error");
            return false;
        }
        mascotaServicio.CambiarEstadoMascota(id, estado);
        return true;
    }
}
