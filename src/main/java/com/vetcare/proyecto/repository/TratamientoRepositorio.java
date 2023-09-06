package com.vetcare.proyecto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Tratamiento;


@Repository
public interface TratamientoRepositorio extends JpaRepository <Tratamiento ,Long> {
    
}
