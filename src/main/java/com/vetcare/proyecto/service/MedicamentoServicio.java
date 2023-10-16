package com.vetcare.proyecto.service;

import java.util.List;

import com.vetcare.proyecto.entities.Medicamento;

public interface MedicamentoServicio {
    
    public void addMedicamento(Medicamento medicamento);


    public Long ventasTotales();

    public Long gananciasTotales();

    public List<Medicamento>top3medicaMentos();

    public Medicamento findById(Long id);

    public List<Medicamento> fiandAll();

    public void actualizarUnidadesDisponiblesYVendidas(Long medicamentoId, int cantidad);

}
