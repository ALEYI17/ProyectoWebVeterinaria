package com.vetcare.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Medicamento;
import com.vetcare.proyecto.repository.MedicamentoRepositorio;

@Service
public class MedicamentoServicioImpl implements MedicamentoServicio{
    @Autowired
    MedicamentoRepositorio medicamentoRepositorio;

    @Override
    public void addMedicamento(Medicamento medicamento) {
        medicamentoRepositorio.save(medicamento);
    }

    @Override
    public Medicamento findById(Long id) {
       return medicamentoRepositorio.findById(id).get();
    }
    
}
