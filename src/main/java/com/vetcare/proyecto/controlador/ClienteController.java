package com.vetcare.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
}
