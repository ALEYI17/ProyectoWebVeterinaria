package com.vetcare.proyecto.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.vetcare.proyecto.entities.Mascota;

public interface MascotaServicio {
    // Obtener una mascota por su ID
    public Mascota GetById(Long id);

    // Obtener todas las mascotas
    public List<Mascota> GetAll();

    // Agregar una nueva mascota
    public void addMascota(Mascota mascota);

    // Eliminar una mascota por su ID
    public void removeMascota(Long id);

    // Actualizar la información de una mascota
    public void updateMascota(Mascota mascota);

    // Obtener varias mascotas por sus IDs
    public ArrayList<Mascota> GetVariousById(ArrayList<Long> ids);
}
