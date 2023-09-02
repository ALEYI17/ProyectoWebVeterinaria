package com.vetcare.proyecto.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.service.ClienteServicio;
import com.vetcare.proyecto.service.MascotaServicio;

@Controller 
@RequestMapping("/cliente")
public class ClienteUsuario {

    @Autowired
    ClienteServicio clienteServicio;
    @Autowired
    MascotaServicio  mascotaServicio;

    @GetMapping("/{id}")
    public String mostrarPaginaCliente(@PathVariable("id") Long id,Model model){
        Cliente cliente = clienteServicio.GetById(id);
        ArrayList<Mascota> pets = mascotaServicio.GetVariousById(cliente.getMisMascotas());
        model.addAttribute("cliente", cliente);
        model.addAttribute("pets", pets);
        return "Mostrar_DashBoard_Cliente";
    }
    
}
