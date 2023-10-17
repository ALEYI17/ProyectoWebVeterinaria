package com.vetcare.proyecto.service;

import com.vetcare.proyecto.entities.Admin;

public interface AdminServicio {
     // Método para obtener un administrador por usuario y contraseña
    public Admin GetAdmin(String usuario,String contrasena);
    
}
