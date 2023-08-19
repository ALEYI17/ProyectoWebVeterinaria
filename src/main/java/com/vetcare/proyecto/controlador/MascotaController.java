package com.vetcare.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String MostrarMascotaXId(Model model, @RequestParam("id") int id){

        Mascota mascota = mascotaServicio.GetById(id);
        if(mascota != null){
            model.addAttribute("Mascota", mascota);
        }

        return "Mostrar_mascota_ID";
    } 
    
    
}
