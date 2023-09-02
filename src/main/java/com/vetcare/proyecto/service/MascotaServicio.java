package com.vetcare.proyecto.service;

import java.util.ArrayList;
import java.util.Collection;

import com.vetcare.proyecto.entities.Mascota;

public interface MascotaServicio {
    public Mascota GetById(Long id);

    public Collection<Mascota> GetAll();

    public void addMascota(Mascota mascota);

    public void removeMascota(Long id);

    public void updateMascota(Mascota mascota);

    public ArrayList<Mascota> GetVariousById(ArrayList<Long> ids);
}
