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
import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.service.ClienteServicio;
import com.vetcare.proyecto.service.VeterinarioServicio;

@Controller
public class logInController {

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    VeterinarioServicio veterinarioServicio;

    Logger log = LoggerFactory.getLogger(getClass());

    // Mostrar la página de inicio de sesión general
    //http://localhost:8090/login
    
    @GetMapping("/login")
    public String mostrarPaginaLogin() {

        return "Login/Login";
    }

    @PostMapping("/Veterinariologin")
    public String handleVeterinarioLoginForm(@ModelAttribute("veterinario") Veterinario veterinario, Model model){
        String cedula = veterinario.getCedula();
        String contrasena = veterinario.getContrasena();
        log.info(cedula);
        log.info(contrasena);
        Veterinario veterinarioLogin = veterinarioServicio.VeterianarioByCedulaYContrasena(cedula, contrasena);

        if(veterinarioLogin == null){
            model.addAttribute("errorMessage", "Credenciales de inicio de sesión no válidas");
            return "Login/login";
        }
        return "redirect:Mascota/todas";
    }

    // Mostrar la página de inicio de sesión de cliente
    //http://localhost:8090/login/cliente
    @GetMapping("/login/cliente")
    public String mostrarPaginaLoginCliente() {
        return "Login/LoginCliente";
    }

  

    // Manejar el formulario de inicio de sesión de cliente
    @PostMapping("/clientelogin")
    public String handleClienteLoginForm(@ModelAttribute("cliente") Cliente cliente, Model model) {
        // Ahora puedes acceder al atributo cedula del objeto cliente
        String cedula = cliente.getCedula();
        log.info(cedula);
        Cliente clienteLogIn = clienteServicio.getByCedula(cedula);

        if (clienteLogIn == null) {
            model.addAttribute("errorMessage", "Credenciales de inicio de sesión no válidas");
            return "Login/LoginCliente"; // Volver a la página de inicio de sesión con un mensaje de error
        }

        return "redirect:/cliente/" + clienteLogIn.getCedula();
    }
}
