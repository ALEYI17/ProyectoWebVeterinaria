package com.vetcare.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import com.vetcare.proyecto.entities.Medicamento;

@Repository
public interface MedicamentoRepositorio extends JpaRepository<Medicamento,Long> {

        
    @Query("SELECT SUM(m.unidadesVendidas * m.precioVenta) FROM Medicamento m")
    public Long totalDeVentas();


    @Query("SELECT SUM((m.unidadesVendidas * m.precioVenta) + t.precio) " +
           "FROM Medicamento m " +
           "JOIN m.tratamiento t " +
           "WHERE t.activo = true")
    public Long gananciasTotales();

    @Query("SELECT m FROM Medicamento m ORDER BY m.unidadesVendidas DESC")
    public List<Medicamento> top3Medicamentos(Pageable pageable);

    
}
