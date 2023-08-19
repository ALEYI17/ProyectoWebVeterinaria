package com.vetcare.proyecto.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.repository.MascotaRepository;

public class MascotaServicioImpl implements MascotaServicio {
    @Autowired
    MascotaRepository repoMascotas;

    @Override
    public Mascota GetById(int id) {
        return repoMascotas.SeracrhById(id);
    }

    @Override
    public Collection<Mascota> GetAll() {
        return repoMascotas.findAll();
    }

    
}
