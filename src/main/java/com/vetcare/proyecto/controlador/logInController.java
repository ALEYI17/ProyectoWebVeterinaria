package com.vetcare.proyecto.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.service.ClienteServicio;

@Controller
public class logInController {

    @Autowired
    ClienteServicio clienteServicio;

    Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("/login")
    public String mostrarPaginaLogin(){


        return "Login";
    }

    
    @GetMapping("/login/cliente")
    public String mostrarPaginaLoginCliente(Model model){

        return "LoginCliente";
    }

    @PostMapping("/clientelogin")
    public String handleClienteLoginForm(@ModelAttribute("cliente") Cliente cliente, Model model) {
        // Now you can access the cedula attribute of the cliente object
        String cedula = cliente.getCedula();
        log.info(cedula);
        Cliente clienteLogIn = clienteServicio.GetById(cedula);
        if(clienteLogIn == null){
            model.addAttribute("errorMessage", "Invalid login credentials");
            return "LoginCliente"; // Return to the login page with an error message
        }
        // Perform necessary business logic using cedula
        
        return "redirect:/cliente"; // Redirect to a success page after processing
    }
}
