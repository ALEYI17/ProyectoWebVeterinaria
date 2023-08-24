package com.vetcare.proyecto.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.repository.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRespositorio;

    @Override
    public Cliente GetById(String id) {
        return clienteRespositorio.SearchById(id);
    }

    @Override
    public Collection<Cliente> GetAll() {
        return clienteRespositorio.findAll();
    }

    @Override
    public void addCliente(Cliente cliente) {
        clienteRespositorio.add(cliente);
    }

    @Override
    public void removerCliente(String id) {
       clienteRespositorio.removeById(id);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        clienteRespositorio.updateById(cliente);
    }
    
}
