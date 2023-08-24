package com.vetcare.proyecto.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vetcare.proyecto.entities.Cliente;

@Controller
public class logInController {

    Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("/login")
    public String mostrarPaginaLogin(){


        return "Login";
    }

    
    @GetMapping("/login/cliente")
    public String mostrarPaginaLoginCliente(){
        return "LoginCliente";
    }

    @PostMapping("/clientelogin")
    public String handleClienteLoginForm(@ModelAttribute("cliente") Cliente cliente, Model model) {
        // Now you can access the cedula attribute of the cliente object
        String cedula = cliente.getCedula();
        log.info(cedula);
        // Perform necessary business logic using cedula
        
        return "redirect:/cliente"; // Redirect to a success page after processing
    }
}
