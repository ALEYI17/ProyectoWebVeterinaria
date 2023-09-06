package com.vetcare.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Medicamento;

@Repository
public interface MedicamentoRepositorio extends JpaRepository<Medicamento,Long> {
    
}
