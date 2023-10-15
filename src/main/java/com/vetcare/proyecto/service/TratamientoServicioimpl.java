package com.vetcare.proyecto.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.repository.TratamientoRepositorio;

@Service
public class TratamientoServicioimpl implements TratamientoServicio {

    @Autowired
    TratamientoRepositorio tratamientoRepository;

    @Override
    public Long CountTratamientosUltimoMes() {
        
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicioMes = fechaActual.minusMonths(1).withDayOfMonth(1);
        LocalDate fechaFinMes = fechaActual.withDayOfMonth(fechaActual.lengthOfMonth());

        Date fechaInicio = Date.from(fechaInicioMes.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(fechaFinMes.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return tratamientoRepository.countTratamientosEnUltimoMes(fechaInicio, fechaFin);
    }
    
}
