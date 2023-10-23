package com.vetcare.proyecto.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Medicamento;
import com.vetcare.proyecto.entities.Tratamiento;
import com.vetcare.proyecto.repository.TratamientoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class TratamientoServicioimpl implements TratamientoServicio {

    @Autowired
    TratamientoRepositorio tratamientoRepository;

    // Método para contar los tratamientos realizados en el último mes
    @Override
    public Long CountTratamientosUltimoMes() {
        
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicioMes = fechaActual.minusMonths(1).withDayOfMonth(1);
        LocalDate fechaFinMes = fechaActual.withDayOfMonth(fechaActual.lengthOfMonth());

        Date fechaInicio = Date.from(fechaInicioMes.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(fechaFinMes.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return tratamientoRepository.countTratamientosEnUltimoMes(fechaInicio, fechaFin);
    }
    // Método para obtener información sobre tratamientos y medicamentos
    @Override
    public List<Object[]> tratamientomedicamento() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicioMes = fechaActual.minusMonths(1).withDayOfMonth(1);
        LocalDate fechaFinMes = fechaActual.withDayOfMonth(fechaActual.lengthOfMonth());

        Date fechaInicio = Date.from(fechaInicioMes.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(fechaFinMes.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return tratamientoRepository.countTratamientosPorTipoEnUltimoMes(fechaInicio, fechaFin);
    }
    // Método para añadir un tratamiento
    @Override
    public Tratamiento anadirTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }
    // Método para cambiar el estado activo de un tratamiento por su ID
    @Override
    @Transactional
    public void cambiarEstadoActivo(Long tratamientoId, boolean nuevoEstadoActivo) {
        int updatedRows = tratamientoRepository.updateActivoById(tratamientoId, nuevoEstadoActivo);
        if (updatedRows > 0) {
            // Éxito: El atributo "activo" se actualizó correctamente.
        } else {
            // Error: No se pudo actualizar el atributo "activo".
        }
    }
    @Override
    public Medicamento getMedicamentosByTratamiento(Long id) {
        Tratamiento tratamiento = tratamientoRepository.findById(id).get();
        Medicamento medicamento = tratamiento.getMedicamentos();
        return medicamento;

    }
    
}
