package com.vetcare.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.service.VeterinarioServicio;

@RestController
@RequestMapping("/Veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {
    @Autowired
    VeterinarioServicio veterinarioServicio;

    @GetMapping("/todos")
    public List<Veterinario>  MostrarVeterinarios(){
        return veterinarioServicio.GetAll();
    }
}
