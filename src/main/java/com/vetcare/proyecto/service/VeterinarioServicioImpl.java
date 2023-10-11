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

    @Override
    public Veterinario findVeterinarioById(Long id) {

        return veterinarioRepositorio.findById(id).get();

    }

    @Override
    public void addVeterinario(Veterinario veterinario) {
        veterinarioRepositorio.save(veterinario);
    }

    @Override
    public void removerVeterinario(Long id) {
       veterinarioRepositorio.deleteById(id);
    }

    @Override
    public void updateVeterinario(Veterinario veterinario) {
        veterinarioRepositorio.save(veterinario);
    }
    
}
