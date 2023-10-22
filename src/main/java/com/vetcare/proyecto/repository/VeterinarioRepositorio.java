package com.vetcare.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vetcare.proyecto.entities.Veterinario;

@Repository
public interface VeterinarioRepositorio extends JpaRepository<Veterinario,Long>   {
    // Consulta para encontrar un veterinario por su cédula y contraseña
    @Query("SELECT v FROM Veterinario v WHERE v.cedula = ?1 AND v.contrasena = ?2")
    public Veterinario findVeterinarioByNombreAndContrasena(String cedula , String contrasena);
    // Consulta para desactivar un veterinario por su ID
    @Query("UPDATE Veterinario v SET v.activo = false WHERE v.id = ?1")
    @Modifying
    @Transactional
    public void desactivarVeterinarioPorId(Long id);

    // Consulta para encontrar todos los veterinarios activos
    List<Veterinario> findByActivoTrue();

    // Consulta para contar la cantidad de veterinarios activos
    long countByActivoTrue();
     // Consulta para contar la cantidad de veterinarios inactivos
    long countByActivoFalse();
}
