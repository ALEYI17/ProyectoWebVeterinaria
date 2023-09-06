package com.vetcare.proyecto.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
// Anotación @Repository para indicar que esta interfaz es un repositorio de Spring
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    // Método para buscar un cliente por su número de cédula
    public Cliente findByCedula(String cedula);

    // Método para eliminar un cliente por su número de cédula
    public void deleteByCedula(String cedula);
}
