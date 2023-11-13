package com.vetcare.proyecto.controlador;

import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vetcare.proyecto.DTOs.VeterinarioDto;
import com.vetcare.proyecto.DTOs.VeterinarioMapper;
import com.vetcare.proyecto.entities.Admin;
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.security.JwtGenerator;
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

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtGenerator jwtGenerator;

    Logger log = LoggerFactory.getLogger(getClass());


    // http://localhost:8090/Veterinariologin
    // Maneja la solicitud de inicio de sesión de un veterinario
    @PostMapping("/Veterinariologin")
    public ResponseEntity handleVeterinarioLoginForm(@RequestBody Veterinario veterinario){
        // String cedula = veterinario.getCedula();
        // String contrasena = veterinario.getContrasena();
        // log.info(cedula);
        // log.info(contrasena);
        // Veterinario veterinarioLogin = veterinarioServicio.VeterianarioByCedulaYContrasena(cedula, contrasena);
        // VeterinarioDto vetetdto = VeterinarioMapper.INSTANCE.convert(veterinarioLogin);
        // if(veterinarioLogin == null || veterinarioLogin.isActivo() == false){
        //    log.info("mal");
        //     return new VeterinarioDto("mal"); // Devuelve falso si el inicio de sesión no tiene éxito
        // }
        // return vetetdto; // Devuelve verdadero si el inicio de sesión es exitoso

         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(veterinario.getCedula(), veterinario.getContrasena()));

         SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);


    }

    // http://localhost:8090/AdminLogin
    // Maneja la solicitud de inicio de sesión de un administrador
    @PostMapping("/AdminLogin")
    public ResponseEntity handleAdminLoginForm(@RequestBody Admin admin){

        // String usuString = admin.getUsuario();
        // String contraString= admin.getContrasena();
        // Admin admin2 = adminServicio.GetAdmin(usuString,contraString);

        // if(admin2 != null){
        //     return true; // Devuelve verdadero si el inicio de sesión es exitoso
        // }
        // return false; // Devuelve falso si el inicio de sesión no tiene éxito

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getUsuario(),admin.getContrasena() ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }



  
    // http://localhost:8090/clientelogin
    // Maneja la solicitud de inicio de sesión de un cliente
    @PostMapping("/clientelogin")
    public ResponseEntity handleClienteLoginForm(@RequestBody Cliente cliente) {
        // Ahora puedes acceder al atributo cedula del objeto cliente
    //     String cedula = cliente.getCedula();
    //     log.info(cedula);
    //     Cliente clienteLogIn = clienteServicio.getByCedula(cedula);

    //     if (clienteLogIn == null) {
    //         // model.addAttribute("errorMessage", "Credenciales de inicio de sesión no válidas");
    //         return clienteLogIn = new Cliente("invalid","","",""); // Volver a la página de inicio de sesión con un mensaje de error
    //     }

    //     return clienteLogIn;  // Devuelve el objeto Cliente si el inicio de sesión es exitoso
    
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(cliente.getCedula(), "123"));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }


    @GetMapping("/authority")
    public ResponseEntity<Collection<String>> buscarCliente(){
    
         Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        Collection<String> roles = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

        return new ResponseEntity<Collection<String>>(roles, HttpStatus.OK);
    }

}
