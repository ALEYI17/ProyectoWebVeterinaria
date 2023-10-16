package com.vetcare.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Tratamiento;

@Service
public interface TratamientoServicio {

    public Long CountTratamientosUltimoMes();

    public List<Object[]> tratamientomedicamento();

    public void anadirTratamiento(Tratamiento tratamiento);
    
}
