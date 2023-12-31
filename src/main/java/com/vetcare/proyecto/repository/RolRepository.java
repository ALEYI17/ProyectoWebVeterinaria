package com.vetcare.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetcare.proyecto.entities.Rol;

public interface RolRepository extends JpaRepository<Rol,Long>{
    
    Optional<Rol> findByName(String name);
}
