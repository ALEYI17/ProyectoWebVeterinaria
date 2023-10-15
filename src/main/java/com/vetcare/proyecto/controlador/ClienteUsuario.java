package com.vetcare.proyecto.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vetcare.proyecto.Exepciones.NotFoundException;
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.service.ClienteServicio;
import com.vetcare.proyecto.service.MascotaServicio;

@Controller 
@RequestMapping("/cliente")
public class ClienteUsuario {

    @Autowired
    ClienteServicio clienteServicio;
    @Autowired
    MascotaServicio  mascotaServicio;

    // Mostrar la página de un cliente y sus mascotas
    //http://localhost:8090/cliente/cedula
    @GetMapping("/{id}")
    public Cliente mostrarPaginaCliente(@PathVariable("id") String id) {
        Cliente cliente = clienteServicio.getByCedula(id);
        if(cliente == null){
            throw new NotFoundException(Long.parseLong(id));
        }
        return cliente;
    }
}
