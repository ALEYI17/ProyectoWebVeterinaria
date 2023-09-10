package com.vetcare.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vetcare.proyecto.Exepciones.NotFoundException;
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.service.ClienteServicio;

@Controller
@RequestMapping("/Clientes")
public class ClienteController {
    @Autowired
    ClienteServicio clienteServicio;

    // Mostrar todos los clientes
    //http://localhost:8090/Clientes/todos
    @GetMapping("/todos")
    public String MostrarClientes(Model model) {
        model.addAttribute("Clientes", clienteServicio.GetAll());
        return "Clientes/Mostrar_todos_clientes";
    }

    // Mostrar un cliente por su ID
    //http://localhost:8090/Clientes/find/cedula
    @GetMapping("/find/{id}")
    public String MostrarClienteXId(Model model, @PathVariable("id") String id) {
        Cliente cliente = clienteServicio.getByCedula(id);
       

        if (cliente != null) {
            List<Mascota> mascotas = cliente.getMisMascotas();
            model.addAttribute("cliente", cliente);
            model.addAttribute("pets", mascotas);
        } else {
            throw new NotFoundException(Long.parseLong(id));
        }

        return "Clientes/Mostrar_cliente_ID";
    }

    // Mostrar el formulario para agregar un nuevo cliente
    //http://localhost:8090/Clientes/add
    @GetMapping("/add")
    public String showCrear(Model model) {
        Cliente cliente = new Cliente(" ", " ", " ", " ");
        model.addAttribute("cliente", cliente);
        return "Clientes/crear_cliente";
    }

    // Agregar un nuevo cliente
    @PostMapping("/agregar")
    public String agregarmascota(@ModelAttribute("cliente") Cliente cliente) {
        clienteServicio.addCliente(cliente);
        return "redirect:/Clientes/todos";
    }

    // Eliminar un cliente por su ID
    @GetMapping("/delete/{id}")
    public String eliminarEstudiante(@PathVariable("id") String id, Model model) {
        clienteServicio.removerClienteByCedula(id);
        return "redirect:/Clientes/todos";
    }

    // Mostrar el formulario para actualizar un cliente
    //http://localhost:8090/Clientes/update/cedula
    @GetMapping("/update/{id}")
    public String actualizarMascota(@PathVariable("id") String id, Model model) {
        Cliente cliente = clienteServicio.getByCedula(id);
        model.addAttribute("cliente", cliente);
        return "Clientes/actualizar_cliente";
    }

    // Actualizar un cliente
    @PostMapping("/update/{id}")
    public String actualizarMascota(@PathVariable("id") String id, @ModelAttribute("mascota") Cliente cliente) {
        clienteServicio.updateCliente(cliente);
        return "redirect:/Clientes/todos";
    }
}
