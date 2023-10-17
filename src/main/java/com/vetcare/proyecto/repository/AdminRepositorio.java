package com.vetcare.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Admin;


@Repository
public interface AdminRepositorio extends JpaRepository<Admin, Long>{
     // Definición de un método personalizado para buscar un administrador por usuario y contraseña.
    @Query("SELECT v FROM Admin v WHERE v.usuario = ?1 AND v.contrasena = ?2")
    public Admin findAdmin(String usuario,String contrasena);
}
