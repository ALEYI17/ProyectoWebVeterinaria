package com.vetcare.proyecto.service;

import java.util.List;

import com.vetcare.proyecto.entities.Veterinario;

public interface VeterinarioServicio {
     // Método para encontrar un veterinario por cédula y contraseña
    public Veterinario VeterianarioByCedulaYContrasena(String Cedula , String contrasena);
     // Método para obtener todos los veterinarios
    public List<Veterinario> GetAll();
    // Método para encontrar un veterinario por su ID
    public Veterinario findVeterinarioById(Long id);
    // Método para agregar un veterinario
    public void addVeterinario(Veterinario veterinario);
     // Método para eliminar un veterinario por su ID
    public void removerVeterinario(Long id);
    // Método para actualizar un veterinario
    public void updateVeterinario(Veterinario veterinario );
    // Método para desactivar un veterinario por su ID
    public void desactivarVeterinarioByID(Long id);
     // Método para obtener todos los veterinarios activos
    List<Veterinario> GetAllVeterinariosActivos();
    // Método para contar la cantidad de veterinarios activos
    Long CountVeterinariosActivos();
    // Método para contar la cantidad de veterinarios inactivos
    Long CountVeterinariosInactivos();
}
