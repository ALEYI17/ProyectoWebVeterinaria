package com.vetcare.proyecto.service;

import java.util.Collection;

import com.vetcare.proyecto.entities.Cliente;



public interface ClienteServicio {
    
    public Cliente GetById(String id);

    public Collection<Cliente> GetAll();

    public void addMascota(Cliente cliente);

    public void removeMascota(String id);

    public void updateMascota(Cliente cliente);
}
