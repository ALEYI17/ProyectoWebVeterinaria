package com.vetcare.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import com.vetcare.proyecto.entities.Medicamento;

@Repository
public interface MedicamentoRepositorio extends JpaRepository<Medicamento,Long> {

        // Consulta para calcular el total de ventas de medicamentos
    @Query("SELECT SUM(m.unidadesVendidas ) FROM Medicamento m")
    public Long totalDeVentas();

        // Consulta para calcular las ganancias totales, incluyendo el precio de tratamiento
    @Query("SELECT SUM((m.unidadesVendidas * m.precioVenta)) " +
           "FROM Medicamento m ")
    public Long gananciasTotales();

     // Consulta para obtener los 3 medicamentos más vendidos
    @Query("SELECT m FROM Medicamento m ORDER BY m.unidadesVendidas DESC")
    public List<Medicamento> top3Medicamentos(Pageable pageable);

     // Modificar las unidades disponibles y vendidas de un medicamento
    @Modifying
    @Query("UPDATE Medicamento m " +
           "SET m.unidadesDisponibles = m.unidadesDisponibles - :cantidad, " +
           "    m.unidadesVendidas = m.unidadesVendidas + :cantidad " +
           "WHERE m.id = :medicamentoId")
    void actualizarUnidadesDisponiblesYVendidas(@Param("medicamentoId") Long medicamentoId, @Param("cantidad") int cantidad);
}
