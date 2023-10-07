package com.vetcare.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.repository.VeterinarioRepositorio;

@Service
public class VeterinarioServicioImpl implements VeterinarioServicio{

    @Autowired
    VeterinarioRepositorio veterinarioRepositorio;

    @Override
    public Veterinario VeterianarioByCedulaYContrasena(String Cedula, String contrasena) {
        return veterinarioRepositorio.findVeterinarioByNombreAndContrasena(Cedula, contrasena);
    }

    @Override
    public List<Veterinario> GetAll() {
        return veterinarioRepositorio.findAll();
    }
    
}
