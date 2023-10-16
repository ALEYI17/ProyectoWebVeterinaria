package com.vetcare.proyecto.service;

import com.vetcare.proyecto.entities.Medicamento;

public interface MedicamentoServicio {
    
    public void addMedicamento(Medicamento medicamento);

    public Medicamento findById(Long id);
}
