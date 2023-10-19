package com.vetcare.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Medicamento;
import com.vetcare.proyecto.repository.MedicamentoRepositorio;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Pageable;

@Service
public class MedicamentoServicioImpl implements MedicamentoServicio{
    @Autowired
    MedicamentoRepositorio medicamentoRepositorio;
    // Método para agregar un medicamento
    @Override
    public void addMedicamento(Medicamento medicamento) {
        medicamentoRepositorio.save(medicamento);
    }
    // Método para calcular el total de ventas de medicamentos
    @Override
    public Long ventasTotales() {
        
        return medicamentoRepositorio.totalDeVentas();

    }
    // Método para calcular las ganancias totales
    @Override
    public Long gananciasTotales() {
       
        return medicamentoRepositorio.gananciasTotales();
    }
     // Método para obtener los 3 medicamentos más vendidos
    @Override
    public List<Medicamento> top3medicaMentos() {
        Pageable top3 = PageRequest.of(0, 3);
        return  medicamentoRepositorio.top3Medicamentos(top3);
    }
    // Método para encontrar un medicamento por su ID
    @Override
    public Medicamento findById(Long id) {
       return medicamentoRepositorio.findById(id).get();

    }
    // Método para obtener todos los medicamentos
    @Override
    public List<Medicamento> fiandAll() {
       return medicamentoRepositorio.findAll();
    }
    // Método para actualizar las unidades disponibles y vendidas de un medicamento
    @Override
    @Transactional
    public void actualizarUnidadesDisponiblesYVendidas(Long medicamentoId, int cantidad)  {
        medicamentoRepositorio.actualizarUnidadesDisponiblesYVendidas(medicamentoId, cantidad);
    }
    @Override
    public Medicamento findMedicamentoById(Long id) {
        Optional<Medicamento> medicamento = medicamentoRepositorio.findById(id);
        return medicamento.orElse(null);
    }

    
    
}
