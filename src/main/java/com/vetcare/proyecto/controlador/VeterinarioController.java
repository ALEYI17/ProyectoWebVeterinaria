package com.vetcare.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetcare.proyecto.DTOs.VeterinarioDto;
import com.vetcare.proyecto.DTOs.VeterinarioMapper;
import com.vetcare.proyecto.Exepciones.NotFoundException;
import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.service.VeterinarioServicio;

@RestController
@RequestMapping("/Veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {
    @Autowired
    VeterinarioServicio veterinarioServicio;

    //http://localhost:8090/Veterinario/todos
    // Obtener todos los veterinarios
    @GetMapping("/todos")
    public List<Veterinario>  MostrarVeterinarios(){
        return veterinarioServicio.GetAllVeterinariosActivos();
    }

    //http://localhost:8090/Veterinario//find/{id}
    // Buscar un veterinario por su ID
    @GetMapping("/find/{id}")
    public VeterinarioDto mosVeterinarioById(@PathVariable("id")Long id){
        Veterinario veterinario = veterinarioServicio.findVeterinarioById(id);
        VeterinarioDto vetetdto = VeterinarioMapper.INSTANCE.convert(veterinario);
        if(veterinario!=null){

        }
        else{
            throw new NotFoundException(id);
        }
        return vetetdto;
    }

    //http://localhost:8090/Veterinario/add
    // Agregar un nuevo veterinario
    @PostMapping("/add")
    public void anadirVeterinario(@RequestBody Veterinario veterinario){
        veterinario.setActivo(true);
        veterinarioServicio.addVeterinario(veterinario);
    }

    //http://localhost:8090/Veterinario//delete/{id}
    // Eliminar un veterinario por su ID
    @DeleteMapping("/delete/{id}")
    public void  eliminarVeterinario(@PathVariable("id") Long id){
        veterinarioServicio.desactivarVeterinarioByID(id);
    }

    //http://localhost:8090/Veterinario/update/{id}
    // Actualizar la información de un veterinario
    @PutMapping("update/{id}")
    public void actualizarVeterinario(@PathVariable("id") Long id ,@RequestBody Veterinario veterinario){
        veterinarioServicio.updateVeterinario(veterinario);
    }

}
