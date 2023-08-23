package com.vetcare.proyecto.service;

import java.util.Collection;

import com.vetcare.proyecto.entities.Mascota;

public interface MascotaServicio {
    public Mascota GetById(int id);

    public Collection<Mascota> GetAll();

    public void addMascota(Mascota mascota);

    public void removeMascota(int id);

    public void updateMascota(Mascota mascota);
}
