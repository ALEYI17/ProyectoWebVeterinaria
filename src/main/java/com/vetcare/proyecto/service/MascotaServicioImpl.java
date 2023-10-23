package com.vetcare.proyecto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.repository.MascotaRepository;

@Service
public class MascotaServicioImpl implements MascotaServicio {
    @Autowired
    MascotaRepository mascotaRepository;

    // Obtener una mascota por su ID
    @Override
    public Mascota GetById(Long id) {
        Optional<Mascota> optionalMascota = mascotaRepository.findById(id);
        return optionalMascota.orElse(null);
    }

    // Obtener todas las mascotas
    @Override
    public List<Mascota> GetAll() {
        return mascotaRepository.findAll();
    }

    // Agregar una nueva mascota
    @Override
    public Mascota addMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    // Eliminar una mascota por su ID
    @Override
    public void removeMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    // Actualizar la información de una mascota
    @Override
    public Mascota updateMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    // Obtener varias mascotas por sus IDs
    @Override
    public ArrayList<Mascota> GetVariousById(ArrayList<Long> ids) {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        for (Long id : ids) {
            Mascota mascota = GetById(id);
            if (mascota != null) {
                mascotas.add(mascota);
            }
        }

        return mascotas;
    }

    @Override
    public Long CountMascotas() {
        return mascotaRepository.count();
    }

    @Override
    public List<Object[]> MascotasTratamientosActivos() {
        
        return mascotaRepository.contarTratamientosActivosPorMascota();
    }
}
