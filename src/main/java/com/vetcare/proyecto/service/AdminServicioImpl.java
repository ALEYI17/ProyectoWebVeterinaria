package com.vetcare.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Admin;
import com.vetcare.proyecto.repository.AdminRepositorio;
@Service
public class AdminServicioImpl implements AdminServicio{

    @Autowired
    AdminRepositorio adminRepositorio;

    @Override
    public Admin GetAdmin(String usuario, String contrasena) {
        return adminRepositorio.findAdmin(usuario,contrasena);
    }
    
}
