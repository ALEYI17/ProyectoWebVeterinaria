package com.vetcare.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface TratamientoServicio {

    public Long CountTratamientosUltimoMes();

    public List<Object[]> tratamientomedicamento();
    
}
