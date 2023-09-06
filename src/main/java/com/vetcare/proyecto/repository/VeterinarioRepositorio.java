package com.vetcare.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Veterinario;

@Repository
public interface VeterinarioRepositorio extends JpaRepository<Veterinario,Long>   {
    
}
