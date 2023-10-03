package com.vetcare.proyecto.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.repository.ClienteRepositorio;

import jakarta.transaction.Transactional;
@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    // Obtener un cliente por su ID
    @Override
    public Cliente GetById(Long id) {
        return clienteRepositorio.findById(id).get();
    }

    // Obtener todos los clientes
    @Override
    public List<Cliente> GetAll() {
        return clienteRepositorio.findAll();
    }

    // Agregar un nuevo cliente
    @Override
    public void addCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    // Eliminar un cliente por su ID
    @Override
    public void removerCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }

    // Actualizar la información de un cliente
    @Override
    public void updateCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    // Obtener un cliente por su número de cédula
    @Override
    public Cliente getByCedula(String cedula) {
        return clienteRepositorio.findByCedula(cedula);
    }

    // Eliminar un cliente por su número de cédula usando una transacción
    @Override
    @Transactional
    public void removerClienteByCedula(String cedula) {
        clienteRepositorio.deleteByCedula(cedula);
    }
}
