package com.vetcare.proyecto.controlador;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetcare.proyecto.Exepciones.NotFoundException;
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.UserEntity;
import com.vetcare.proyecto.repository.UserEntityRepository;
import com.vetcare.proyecto.security.CustomUserDetailService;
import com.vetcare.proyecto.service.ClienteServicio;




@RestController
@RequestMapping("/Clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    CustomUserDetailService customUserDetailService;

    // Mostrar todos los clientes
    //http://localhost:8090/Clientes/todos
    @GetMapping("/todos")
    public List<Cliente> MostrarClientes() {
        
        return clienteServicio.GetAll();
    }

    // Mostrar un cliente por su ID
    //http://localhost:8090/Clientes/find/cedula
    @GetMapping("/find/{id}")
    public Cliente MostrarClienteXId( @PathVariable("id") String id) {
        Cliente cliente = clienteServicio.getByCedula(id);
       

        if (cliente != null) {
           // List<Mascota> mascotas = cliente.getMisMascotas();
           
        } else {
            throw new NotFoundException(Long.parseLong(id));
        }

        return cliente;
    }

    // Agregar un nuevo cliente
    //http://localhost:8090/Clientes/add
    @PostMapping("/add")
    public ResponseEntity agregarmascota(@RequestBody  Cliente cliente) {

        if(userEntityRepository.existsByUsername(cliente.getCedula())){
            return new ResponseEntity<String>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        
        UserEntity userEntity = customUserDetailService.ClienteToUser(cliente);
        cliente.setUser(userEntity);
        Cliente newCliente = clienteServicio.addCliente(cliente);

        return new  ResponseEntity<Cliente>(newCliente , HttpStatus.CREATED);
    }

    // Eliminar un cliente por su ID
    //http://localhost:8090/Clientes/delete/id
    @DeleteMapping("/delete/{id}")
    public void eliminarEstudiante(@PathVariable("id") String id) {
        clienteServicio.removerClienteByCedula(id);
        // return "redirect:/Clientes/todos";
    }

    // Actualizar un cliente
    //http://localhost:8090/Clientes/update/id
    @PutMapping("/update/{id}")
    public void actualizarMascota(@PathVariable("id") String id, @RequestBody Cliente cliente) {
        clienteServicio.updateCliente(cliente);
        // return "redirect:/Clientes/todos";
    }
}
