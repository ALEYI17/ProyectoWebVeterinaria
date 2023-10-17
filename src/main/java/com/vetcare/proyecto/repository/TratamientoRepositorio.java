package com.vetcare.proyecto.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Tratamiento;


@Repository
public interface TratamientoRepositorio extends JpaRepository <Tratamiento ,Long> {

     // Consulta para contar tratamientos en el último mes
    @Query("SELECT COUNT(t) FROM Tratamiento t WHERE t.Fecha >= :fechaInicio AND t.Fecha <= :fechaFin")
    long countTratamientosEnUltimoMes(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
    // Consulta para contar tratamientos por tipo en el último mes
    @Query("SELECT m.nombre AS nombreMedicamento, COUNT(t) AS cantidadTratamientos " +
           "FROM Tratamiento t " +
           "JOIN t.medicamentos m " +
           "WHERE t.Fecha >= :fechaInicio AND t.Fecha <= :fechaFin " +
           "GROUP BY m.nombre")
    List<Object[]> countTratamientosPorTipoEnUltimoMes(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

     // Operación para actualizar el estado activo de un tratamiento por ID
    @Modifying
    @Query("UPDATE Tratamiento t SET t.activo = :activo WHERE t.id = :tratamientoId")
    int updateActivoById(@Param("tratamientoId") Long tratamientoId, @Param("activo") boolean activo);

    
}
