package com.vetcare.proyecto.service;

import java.util.ArrayList;
import java.util.Collection;

import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Mascota;



public interface ClienteServicio {
    
    public Cliente GetById(Long id);

    public Collection<Cliente> GetAll();

    public void addCliente(Cliente cliente);

    public void removerCliente(Long id);

    public void updateCliente(Cliente cliente);

    public Cliente getByCedula(String cedula);

}
