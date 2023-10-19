package com.vetcare.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Tratamiento;

@Service
public interface TratamientoServicio {
    // Método para contar los tratamientos realizados en el último mes
    public Long CountTratamientosUltimoMes();
    // Método para obtener información sobre tratamientos y medicamentos
    public List<Object[]> tratamientomedicamento();
     // Método para añadir un tratamiento
    public Tratamiento anadirTratamiento(Tratamiento tratamiento);
    // Método para cambiar el estado activo de un tratamiento por su ID
    public void cambiarEstadoActivo(Long tratamientoId, boolean nuevoEstadoActivo);
    
}
