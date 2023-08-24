package com.vetcare.proyecto.service;

import java.util.Collection;

import com.vetcare.proyecto.entities.Cliente;



public interface ClienteServicio {
    
    public Cliente GetById(String id);

    public Collection<Cliente> GetAll();

    public void addCliente(Cliente cliente);

    public void removerCliente(String id);

    public void updateCliente(Cliente cliente);
}
