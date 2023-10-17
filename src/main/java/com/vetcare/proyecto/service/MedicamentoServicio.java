package com.vetcare.proyecto.service;

import java.util.List;

import com.vetcare.proyecto.entities.Medicamento;

public interface MedicamentoServicio {
     // Método para agregar un medicamento
    public void addMedicamento(Medicamento medicamento);

    // Método para calcular el total de ventas de medicamentos
    public Long ventasTotales();
    // Método para calcular las ganancias totales
    public Long gananciasTotales();
    // Método para obtener los 3 medicamentos más vendidos
    public List<Medicamento>top3medicaMentos();
     // Método para encontrar un medicamento por su ID
    public Medicamento findById(Long id);
    // Método para obtener todos los medicamentos
    public List<Medicamento> fiandAll();
    // Método para actualizar las unidades disponibles y vendidas de un medicamento
    public void actualizarUnidadesDisponiblesYVendidas(Long medicamentoId, int cantidad);

}
