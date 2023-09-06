package com.vetcare.proyecto.service;

import com.vetcare.proyecto.entities.Veterinario;

public interface VeterinarioServicio {
    public Veterinario VeterianarioByCedulaYContrasena(String Cedula , String contrasena);
}
