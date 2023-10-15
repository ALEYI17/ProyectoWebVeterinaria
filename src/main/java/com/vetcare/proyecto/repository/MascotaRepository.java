package com.vetcare.proyecto.repository;



import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Anotación @Repository para indicar que esta interfaz es un repositorio de Spring
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    long countAll();

    @Query("SELECT COUNT(m) FROM Mascota m WHERE SIZE(m.tratamientos) > 0")
    long countMascotasConTratamientos();
}
