package com.vetcare.proyecto.repository;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Tratamiento;


@Repository
public interface TratamientoRepositorio extends JpaRepository <Tratamiento ,Long> {

    @Query("SELECT COUNT(t) FROM Tratamiento t WHERE t.Fecha >= :fechaInicio AND t.Fecha <= :fechaFin")
    long countTratamientosEnUltimoMes(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
    
}
