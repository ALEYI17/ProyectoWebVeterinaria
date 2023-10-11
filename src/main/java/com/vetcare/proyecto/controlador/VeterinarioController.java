package com.vetcare.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetcare.proyecto.Exepciones.NotFoundException;
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

    @GetMapping("/find/{id}")
    public Veterinario mosVeterinarioById(@PathVariable("id")Long id){
        Veterinario veterinario = veterinarioServicio.findVeterinarioById(id);
        if(veterinario!=null){

        }
        else{
            throw new NotFoundException(id);
        }
        return veterinario;
    }

    @PostMapping("/add")
    public void anadirVeterinario(@RequestBody Veterinario veterinario){
        veterinarioServicio.addVeterinario(veterinario);
    }

    @DeleteMapping("/delete/{id}")
    public void  eliminarVeterinario(@PathVariable("id") Long id){
        veterinarioServicio.removerVeterinario(id);
    }

    @PostMapping("update/{id}")
    public void actualizarVeterinario(@PathVariable("id") Long id ,@RequestBody Veterinario veterinario){
        veterinarioServicio.updateVeterinario(veterinario);
    }

}
