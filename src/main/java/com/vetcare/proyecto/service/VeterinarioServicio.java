package com.vetcare.proyecto.service;

import java.util.List;

import com.vetcare.proyecto.entities.Veterinario;

public interface VeterinarioServicio {
    public Veterinario VeterianarioByCedulaYContrasena(String Cedula , String contrasena);

    public List<Veterinario> GetAll();
}
