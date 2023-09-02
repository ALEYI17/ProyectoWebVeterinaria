package com.vetcare.proyecto.controlador;

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
import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.service.MascotaServicio;


@Controller
@RequestMapping("/Mascota")
public class MascotaController {
    @Autowired
    MascotaServicio  mascotaServicio;

    @GetMapping("/todas")
    public String MostrarMascotas(Model model){
        model.addAttribute("Mascotas",mascotaServicio.GetAll());
        return "Mostrar_todas_mascotas";
    }

    @GetMapping("/find")
    public String MostrarMascotaXId(Model model, @RequestParam("id") Long id){

        Mascota mascota = mascotaServicio.GetById(id);
        if(mascota != null){
            model.addAttribute("Mascota", mascota);
        } 
        else{
            throw new NotFoundException(id);
        }

        return "Mostrar_mascota_ID";
    }

    @GetMapping("find/{id}")
    public String mostrarInfoMascota2(Model model,@PathVariable("id") Long id){
        Mascota mascota = mascotaServicio.GetById(id);
        if(mascota != null){
            model.addAttribute("Mascota", mascota);
        }
        else{
            throw new NotFoundException(id);
        }

        return "Mostrar_mascota_ID";
    }
    
    @GetMapping("/add")
    public String Showcrear(Model model){
        Mascota mascota = new Mascota(" ", " ", 0, 0.0, " ");
        model.addAttribute("mascota", mascota);
        return "crear_Mascota";
    }

    @PostMapping("/agregar")
    public String agregarmascota(@ModelAttribute("mascota") Mascota mascota){
        mascotaServicio.addMascota(mascota);
        return "redirect:/Mascota/todas";
    }

    @GetMapping("/delete/{id}")
    public String eliminarEstudiante(@PathVariable("id") Long id , Model model){
        mascotaServicio.removeMascota(id);
        return "redirect:/Mascota/todas";
    }

    @GetMapping("/update/{id}")
    public String actualizarMascota(@PathVariable("id")Long id , Model model){
        Mascota mascota = mascotaServicio.GetById(id);
        model.addAttribute("mascota",mascota);
        return "actualizar_mascota";
    }

    @PostMapping("/update/{id}")
    public String actualizarMascota(@PathVariable("id") int id , @ModelAttribute("mascota") Mascota mascota){
        mascotaServicio.updateMascota(mascota);
        return "redirect:/Mascota/todas";
    }
    
    
}
