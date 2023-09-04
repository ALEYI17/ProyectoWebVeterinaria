package com.vetcare.proyecto.controlador;



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
import com.vetcare.proyecto.service.ClienteServicio;


@Controller
@RequestMapping("/Clientes")
public class ClienteController {
    @Autowired
    ClienteServicio clienteServicio;

    @GetMapping("/todos")
    public String MostrarClientes(Model model){
        model.addAttribute("Clientes", clienteServicio.GetAll());
        return "Mostrar_todos_clientes";
    }

    @GetMapping("/find/{id}")
    public String MostrarClienteXId(Model model , @PathVariable("id") String id){
        Cliente cliente = clienteServicio.getByCedula(id);
        
        if(cliente != null){
            model.addAttribute("cliente", cliente);
        }
        else{
            throw new NotFoundException(Long.parseLong(id));
        }
        
        return "Mostrar_cliente_ID";
    }

    @GetMapping("/add")
    public String showCrear(Model model){
        Cliente cliente = new Cliente(" ", " ", " ", " ");

        model.addAttribute("cliente", cliente);
        return "crear_cliente";
    }

    @PostMapping("/agregar")
    public String agregarmascota(@ModelAttribute("cliente") Cliente cliente){
        clienteServicio.addCliente(cliente);
        return "redirect:/Clientes/todos";
    }

    @GetMapping("/delete/{id}")
    public String eliminarEstudiante(@PathVariable("id") String id , Model model){
        
        clienteServicio.removerClienteByCedula(id);
        return "redirect:/Clientes/todos";
    }

    @GetMapping("/update/{id}")
    public String actualizarMascota(@PathVariable("id")String id , Model model){
        Cliente cliente = clienteServicio.getByCedula(id);
        model.addAttribute("cliente",cliente);
        return "actualizar_cliente";
    }

    @PostMapping("/update/{id}")
    public String actualizarMascota(@PathVariable("id") String id , @ModelAttribute("mascota") Cliente cliente){
        clienteServicio.updateCliente(cliente);
        return "redirect:/Clientes/todos";
    }
    
}
