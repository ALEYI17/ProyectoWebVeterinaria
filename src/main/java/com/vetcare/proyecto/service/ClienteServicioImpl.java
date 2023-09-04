package com.vetcare.proyecto.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.repository.ClienteRepositorio;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public Cliente GetById(Long id) {
        return clienteRepositorio.findById(id).get();
    }

    @Override
    public Collection<Cliente> GetAll() {
        return clienteRepositorio.findAll();
    }

    @Override
    public void addCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    @Override
    public void removerCliente(Long id) {
       clienteRepositorio.deleteById(id);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente getByCedula(String cedula) {
        return clienteRepositorio.findByCedula(cedula);
    }

    @Override
    @Transactional
    public void removerClienteByCedula(String Cedula){

        clienteRepositorio.deleteByCedula(Cedula);

    }

    
    
}
