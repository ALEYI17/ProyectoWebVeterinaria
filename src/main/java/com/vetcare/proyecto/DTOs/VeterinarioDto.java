package com.vetcare.proyecto.DTOs;

import lombok.Data;

@Data
public class VeterinarioDto {

    private String Nombre;
    private Long id;
    private String cedula; 
    private String especialidad; 
    private String foto; 

    public VeterinarioDto(String nombre) {
        Nombre = nombre;
    }

    
}
