package com.vetcare.proyecto.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Long>{
    public Cliente findByCedula(String cedula);
    public void deleteByCedula(String Cedula);
}
