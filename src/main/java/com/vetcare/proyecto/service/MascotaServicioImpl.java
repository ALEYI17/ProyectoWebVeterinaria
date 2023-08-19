package com.vetcare.proyecto.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.repository.MascotaRepository;

@Service
public class MascotaServicioImpl implements MascotaServicio {
    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public Mascota GetById(int id) {
        return mascotaRepository.SeracrhById(id);
    }

    @Override
    public Collection<Mascota> GetAll() {
        return mascotaRepository.findAll();
    }

    
}
