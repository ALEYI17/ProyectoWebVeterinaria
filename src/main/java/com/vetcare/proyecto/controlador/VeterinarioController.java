package com.vetcare.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.UserEntity;
import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.repository.UserEntityRepository;
import com.vetcare.proyecto.security.CustomUserDetailService;
import com.vetcare.proyecto.service.VeterinarioServicio;

@RestController
@RequestMapping("/Veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {
    @Autowired
    VeterinarioServicio veterinarioServicio;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    CustomUserDetailService customUserDetailService;

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
    public ResponseEntity anadirVeterinario(@RequestBody Veterinario veterinario){

        if(userEntityRepository.existsByUsername(veterinario.getCedula())){
            return new ResponseEntity<String>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = customUserDetailService.VeterinarioToUser(veterinario);
        veterinario.setUser(userEntity);
        veterinario.setActivo(true);
        Veterinario veterinarioDB = veterinarioServicio.addVeterinario(veterinario);
        VeterinarioDto newVeterinarioDto = VeterinarioMapper.INSTANCE.convert(veterinarioDB);
        if(newVeterinarioDto == null){
            return new ResponseEntity<VeterinarioDto>(newVeterinarioDto, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<VeterinarioDto>(newVeterinarioDto, HttpStatus.CREATED);
    }

    //http://localhost:8090/Veterinario//details/
    // Devuelve info de veterinario
    @GetMapping("/details")
    public ResponseEntity<VeterinarioDto> buscarVeterinario(){
        Veterinario veterinario = veterinarioServicio.GetbyCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );

        VeterinarioDto vetetdto = VeterinarioMapper.INSTANCE.convert(veterinario);

        if(veterinario == null ){
            return new ResponseEntity<VeterinarioDto>(vetetdto, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<VeterinarioDto>(vetetdto, HttpStatus.OK);
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

        Veterinario veterinarioActualziar = veterinarioServicio.GetById(veterinario.getId());
        veterinario.setUser(veterinarioActualziar.getUser());
        veterinario.setContrasena(veterinarioActualziar.getContrasena());
        veterinario.setActivo(true);
        veterinarioServicio.updateVeterinario(veterinario);
    }

}
