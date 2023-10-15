package com.vetcare.proyecto.repository;



import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

// Anotación @Repository para indicar que esta interfaz es un repositorio de Spring
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
