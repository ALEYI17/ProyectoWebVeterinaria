package com.vetcare.proyecto.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.vetcare.proyecto.entities.Mascota;

import lombok.Data;

@Data
public class ClienteDto {

    private String cedula;
    private String nombre;
    private String corre;
    private String celular;
    private Long id;
    List<Mascota> MisMascotas;
    
}
