package com.vetcare.proyecto.service;

import java.util.ArrayList;
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
    public Mascota GetById(Long id) {
        return mascotaRepository.findById(id).get();
    }

    @Override
    public Collection<Mascota> GetAll() {
        return mascotaRepository.findAll();
    }

    @Override
    public void addMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public void removeMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    @Override
    public void updateMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
        
    }

    @Override
    public ArrayList<Mascota> GetVariousById(ArrayList<Long> ids) {
        ArrayList<Mascota> mascotas = new ArrayList<>();


        for(Long id : ids){

            Mascota mascota = GetById(id);
            if (mascota != null) {
                mascotas.add(mascota);
            }

        }

        return mascotas;
    }



    
}
