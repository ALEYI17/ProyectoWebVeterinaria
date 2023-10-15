package com.vetcare.proyecto.service;

import java.util.List;

import com.vetcare.proyecto.entities.Veterinario;

public interface VeterinarioServicio {
    public Veterinario VeterianarioByCedulaYContrasena(String Cedula , String contrasena);

    public List<Veterinario> GetAll();

    public Veterinario findVeterinarioById(Long id);

    public void addVeterinario(Veterinario veterinario);

    public void removerVeterinario(Long id);

    public void updateVeterinario(Veterinario veterinario );

    public void desactivarVeterinarioByID(Long id);
    
    List<Veterinario> GetAllVeterinariosActivos();

    Long CountVeterinariosActivos();

    Long CountVeterinariosInactivos();
}
