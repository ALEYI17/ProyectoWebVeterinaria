package com.vetcare.proyecto.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    MascotaServicio  mascotaServicio;

    @Autowired
    ClienteServicio clienteServicio;

    // Mostrar todas las mascotas
    // http://localhost:8090/Mascota/todas
    @GetMapping("/todas")
    public List<Mascota> MostrarMascotas(){
        
        return mascotaServicio.GetAll();
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
    public Mascota mostrarInfoMascota2(Model model, @PathVariable("id") Long id){
        Mascota mascota = mascotaServicio.GetById(id);
        
        if(mascota != null){
            // Cliente dueno = mascota.getCliente();
            // model.addAttribute("Mascota", mascota);
            // if(dueno != null){
            //     model.addAttribute("dueno", dueno);
            // }
            
        }
        else{
            throw new NotFoundException(id);
        }
        return mascota;
    }

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
    
    // Mostrar el formulario para agregar una nueva mascota
    //http://localhost:8090/Mascota/add
    // @GetMapping("/add")
    // public String Showcrear(Model model){
    //     Mascota mascota = new Mascota(" ", " ", 0, 0.0, " ","");
    //     model.addAttribute("mascota", mascota);
    //     Collection<Cliente> clientes = clienteServicio.GetAll();
    //     model.addAttribute("clientes", clientes);
    //     return "Mascotas/crear_Mascota";
    // }

    // Agregar una nueva mascota
    // @PostMapping("/agregar")
    // public String agregarmascota(@ModelAttribute("mascota") Mascota mascota,@RequestParam("clientId") String clientId){

    //     Cliente duenno = clienteServicio.GetById(Long.valueOf(clientId));
    //     if(duenno != null){
    //         mascota.setCliente(duenno);
    //     }

    //     mascotaServicio.addMascota(mascota);
    //     return "redirect:/Mascota/todas";
    // }



    @PostMapping("/agregar")
    public void agregarmascota(@RequestBody Mascota mascota, @RequestParam("clientId") String clientId){

        Cliente duenno = clienteServicio.GetById(Long.valueOf(clientId));
        if(duenno != null){
            mascota.setCliente(duenno);
        }

        mascotaServicio.addMascota(mascota);
    }

    // Eliminar una mascota por su ID
    @DeleteMapping("/delete/{id}")
    public void eliminarEstudiante(@PathVariable("id") Long id ){
        mascotaServicio.removeMascota(id);
    }

    // Mostrar el formulario para actualizar una mascota
    //http://localhost:8090/Mascota/update/id
    // @GetMapping("/update/{id}")
    // public String actualizarMascota(@PathVariable("id")Long id , Model model){
    //     Mascota mascota = mascotaServicio.GetById(id);
    //     model.addAttribute("mascota",mascota);
    //     return "Mascotas/actualizar_mascota";
    // }

    // Actualizar una mascota
    @PostMapping("/update/{id}")
    public void actualizarMascota(@PathVariable("id") Long id, 
                                     @RequestBody Mascota mascota,
                                     @RequestParam("cliente.id") String clienteId){
        Cliente duenno = clienteServicio.GetById(Long.parseLong(clienteId));
        if (duenno != null) {
            mascota.setCliente(duenno);
        }
        mascotaServicio.updateMascota(mascota);
       
    }

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

}
