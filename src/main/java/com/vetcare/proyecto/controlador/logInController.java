package com.vetcare.proyecto.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vetcare.proyecto.entities.Admin;
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.service.AdminServicio;
import com.vetcare.proyecto.service.ClienteServicio;
import com.vetcare.proyecto.service.VeterinarioServicio;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class logInController {

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    VeterinarioServicio veterinarioServicio;

    @Autowired
    AdminServicio adminServicio;

    Logger log = LoggerFactory.getLogger(getClass());

    // Mostrar la página de inicio de sesión general
    //http://localhost:8090/login
    
    // @GetMapping("/login")
    // public String mostrarPaginaLogin() {

    //     return "Login/Login";
    // }

    @PostMapping("/Veterinariologin")
    public Boolean handleVeterinarioLoginForm(@RequestBody Veterinario veterinario){
        String cedula = veterinario.getCedula();
        String contrasena = veterinario.getContrasena();
        log.info(cedula);
        log.info(contrasena);
        Veterinario veterinarioLogin = veterinarioServicio.VeterianarioByCedulaYContrasena(cedula, contrasena);

        if(veterinarioLogin == null){
           
            return false;
        }
        return true;
    }

    @PostMapping("/AdminLogin")
    public Boolean handleAdminLoginForm(@RequestBody Admin admin){
        String usuString = admin.getUsuario();
        String contraString= admin.getContrasena();
        Admin admin2 = adminServicio.GetAdmin(usuString,contraString);

        if(admin2 != null){
            return true;
        }
        return false;
    }

    // Mostrar la página de inicio de sesión de cliente
    //http://localhost:8090/login/cliente
    // @GetMapping("/login/cliente")
    // public String mostrarPaginaLoginCliente() {
    //     return "Login/LoginCliente";
    // }

  

    // Manejar el formulario de inicio de sesión de cliente
    @PostMapping("/clientelogin")
    public Cliente handleClienteLoginForm(@RequestBody Cliente cliente) {
        // Ahora puedes acceder al atributo cedula del objeto cliente
        String cedula = cliente.getCedula();
        log.info(cedula);
        Cliente clienteLogIn = clienteServicio.getByCedula(cedula);

        if (clienteLogIn == null) {
            // model.addAttribute("errorMessage", "Credenciales de inicio de sesión no válidas");
            return clienteLogIn = new Cliente("invalid","","",""); // Volver a la página de inicio de sesión con un mensaje de error
        }

        return clienteLogIn;
    }


}
