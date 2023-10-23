package com.vetcare.proyecto.repository;



import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Mascota;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Anotación @Repository para indicar que esta interfaz es un repositorio de Spring
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

     // Consulta personalizada para contar las mascotas con tratamientos
     @Query("SELECT COUNT(m) FROM Mascota m WHERE m.mascotaTratamiento = true")
     long countMascotasConTratamientos();
     


    
}
