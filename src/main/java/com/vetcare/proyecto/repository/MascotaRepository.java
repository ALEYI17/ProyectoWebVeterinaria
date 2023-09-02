package com.vetcare.proyecto.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MascotaRepository extends  JpaRepository<Mascota,Long>{
}
