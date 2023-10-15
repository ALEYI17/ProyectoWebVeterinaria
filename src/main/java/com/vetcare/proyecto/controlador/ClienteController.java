package com.vetcare.proyecto.controlador;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.service.ClienteServicio;




@RestController
@RequestMapping("/Clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    ClienteServicio clienteServicio;

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

    // Mostrar el formulario para agregar un nuevo cliente
    //http://localhost:8090/Clientes/add
    // @GetMapping("/add")
    // public String showCrear(Model model) {
    //     Cliente cliente = new Cliente(" ", " ", " ", " ");
    //     model.addAttribute("cliente", cliente);
    //     return "Clientes/crear_cliente";
    // }

    // Agregar un nuevo cliente
    @PostMapping("/add")
    public void agregarmascota(@RequestBody  Cliente cliente) {
        clienteServicio.addCliente(cliente);
        
    }

    // Eliminar un cliente por su ID
    @DeleteMapping("/delete/{id}")
    public void eliminarEstudiante(@PathVariable("id") String id) {
        clienteServicio.removerClienteByCedula(id);
        // return "redirect:/Clientes/todos";
    }

    // Mostrar el formulario para actualizar un cliente
    //http://localhost:8090/Clientes/update/cedula
    // @GetMapping("/update/{id}")
    // public String actualizarMascota(@PathVariable("id") String id, Model model) {
    //     Cliente cliente = clienteServicio.getByCedula(id);
    //     model.addAttribute("cliente", cliente);
    //     return "Clientes/actualizar_cliente";
    // }

    // Actualizar un cliente
    @PostMapping("/update/{id}")
    public void actualizarMascota(@PathVariable("id") String id, @RequestBody Cliente cliente) {
        clienteServicio.updateCliente(cliente);
        // return "redirect:/Clientes/todos";
    }
}
