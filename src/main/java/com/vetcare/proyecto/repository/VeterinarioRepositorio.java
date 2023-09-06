package com.vetcare.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Veterinario;

@Repository
public interface VeterinarioRepositorio extends JpaRepository<Veterinario,Long>   {

    @Query("SELECT v FROM Veterinario v WHERE v.cedula = ?1 AND v.contrasena = ?2")
    public Veterinario findVeterinarioByNombreAndContrasena(String cedula , String contrasena);
    
}
