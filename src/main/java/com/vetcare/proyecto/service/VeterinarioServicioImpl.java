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
    // Método para encontrar un veterinario por cédula y contraseña
    @Override
    public Veterinario VeterianarioByCedulaYContrasena(String Cedula, String contrasena) {
        return veterinarioRepositorio.findVeterinarioByNombreAndContrasena(Cedula, contrasena);
    }
     // Método para obtener todos los veterinarios
    @Override
    public List<Veterinario> GetAll() {
        return veterinarioRepositorio.findAll();
    }
    // Método para encontrar un veterinario por su ID
    @Override
    public Veterinario findVeterinarioById(Long id) {

        return veterinarioRepositorio.findById(id).get();

    }
    // Método para agregar un veterinario
    @Override
    public Veterinario addVeterinario(Veterinario veterinario) {
        return veterinarioRepositorio.save(veterinario);
    }
    // Método para eliminar un veterinario por su ID
    @Override
    public void removerVeterinario(Long id) {
       veterinarioRepositorio.deleteById(id);
    }
    // Método para actualizar un veterinario
    @Override
    public void updateVeterinario(Veterinario veterinario) {
        veterinarioRepositorio.save(veterinario);
    }
    // Método para desactivar un veterinario por su ID
    @Override
    public void desactivarVeterinarioByID(Long id) {
        
        veterinarioRepositorio.desactivarVeterinarioPorId(id);

    }
    // Método para obtener todos los veterinarios activos
    @Override
    public List<Veterinario> GetAllVeterinariosActivos() {
        return veterinarioRepositorio.findByActivoTrue();
    }
    // Método para contar la cantidad de veterinarios activos
    @Override
    public Long CountVeterinariosActivos() {
         return veterinarioRepositorio.countByActivoTrue();
    }
    // Método para contar la cantidad de veterinarios inactivos
    @Override
    public Long CountVeterinariosInactivos() {
         return veterinarioRepositorio.countByActivoFalse();
    }
    @Override
    public Veterinario GetbyCedula(String cedula) {
        return veterinarioRepositorio.findByCedula(cedula);
    }
    
}
