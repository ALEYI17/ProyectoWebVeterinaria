package com.vetcare.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Medicamento;
import com.vetcare.proyecto.repository.MedicamentoRepositorio;
import org.springframework.data.domain.Pageable;

@Service
public class MedicamentoServicioImpl implements MedicamentoServicio{
    @Autowired
    MedicamentoRepositorio medicamentoRepositorio;

    @Override
    public void addMedicamento(Medicamento medicamento) {
        medicamentoRepositorio.save(medicamento);
    }

    @Override

    public Long ventasTotales() {
        
        return medicamentoRepositorio.totalDeVentas();

    }

    @Override
    public Long gananciasTotales() {
       
        return medicamentoRepositorio.gananciasTotales();
    }

    @Override
    public List<Medicamento> top3medicaMentos() {
        Pageable top3 = PageRequest.of(0, 3);
        return  medicamentoRepositorio.top3Medicamentos(top3);
    }
    
    public Medicamento findById(Long id) {
       return medicamentoRepositorio.findById(id).get();

    }
    
}
