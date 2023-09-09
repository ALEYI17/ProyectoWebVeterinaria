package com.vetcare.proyecto.controlador;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vetcare.proyecto.Exepciones.NotFoundException;
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.service.ClienteServicio;
import com.vetcare.proyecto.service.MascotaServicio;

@Controller
@RequestMapping("/Mascota")
public class MascotaController {
    @Autowired
    MascotaServicio  mascotaServicio;

    @Autowired
    ClienteServicio clienteServicio;

    // Mostrar todas las mascotas
    // http://localhost:8090/Mascota/todas
    @GetMapping("/todas")
    public String MostrarMascotas(Model model){
        model.addAttribute("Mascotas",mascotaServicio.GetAll());
        return "Mascotas/Mostrar_todas_mascotas";
    }

    // Mostrar una mascota por su ID usando el parámetro de solicitud
    //http://localhost:8090/Mascota/find/id
    @GetMapping("/find")
    public String MostrarMascotaXId(Model model, @RequestParam("id") Long id){
        Mascota mascota = mascotaServicio.GetById(id);
        if(mascota != null){
            model.addAttribute("Mascota", mascota);
        } 
        else{
            throw new NotFoundException(id);
        }
        return "Mascotas/Mostrar_mascota_ID";
    }

    // Mostrar una mascota por su ID usando una variable de ruta
    //http://localhost:8090/Mascota/find/id
    @GetMapping("find/{id}")
    public String mostrarInfoMascota2(Model model, @PathVariable("id") Long id){
        Mascota mascota = mascotaServicio.GetById(id);
        
        if(mascota != null){
            Cliente dueno = mascota.getCliente();
            model.addAttribute("Mascota", mascota);
            if(dueno != null){
                model.addAttribute("dueno", dueno);
            }
            
        }
        else{
            throw new NotFoundException(id);
        }
        return "Mascotas/Mostrar_mascota_ID";
    }
    
    // Mostrar el formulario para agregar una nueva mascota
    //http://localhost:8090/Mascota/add
    @GetMapping("/add")
    public String Showcrear(Model model){
        Mascota mascota = new Mascota(" ", " ", 0, 0.0, " ","");
        model.addAttribute("mascota", mascota);
        Collection<Cliente> clientes = clienteServicio.GetAll();
        model.addAttribute("clientes", clientes);
        return "Mascotas/crear_Mascota";
    }

    // Agregar una nueva mascota
    @PostMapping("/agregar")
    public String agregarmascota(@ModelAttribute("mascota") Mascota mascota,@RequestParam("clientId") String clientId){

        Cliente duenno = clienteServicio.GetById(Long.valueOf(clientId));
        if(duenno != null){
            mascota.setCliente(duenno);
        }

        mascotaServicio.addMascota(mascota);
        return "redirect:/Mascota/todas";
    }

    // Eliminar una mascota por su ID
    @GetMapping("/delete/{id}")
    public String eliminarEstudiante(@PathVariable("id") Long id , Model model){
        mascotaServicio.removeMascota(id);
        return "redirect:/Mascota/todas";
    }

    // Mostrar el formulario para actualizar una mascota
    //http://localhost:8090/Mascota/update/id
    @GetMapping("/update/{id}")
    public String actualizarMascota(@PathVariable("id")Long id , Model model){
        Mascota mascota = mascotaServicio.GetById(id);
        model.addAttribute("mascota",mascota);
        return "Mascotas/actualizar_mascota";
    }

    // Actualizar una mascota
    @PostMapping("/update/{id}")
    public String actualizarMascota(@PathVariable("id") Long id, 
                                     @ModelAttribute("mascota") Mascota mascota,
                                     @RequestParam("cliente.id") Long clienteId){
        Cliente duenno = clienteServicio.GetById(clienteId);
        if (duenno != null) {
            mascota.setCliente(duenno);
        }
        mascotaServicio.updateMascota(mascota);
        return "redirect:/Mascota/todas";
    }
}
