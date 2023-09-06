package com.vetcare.proyecto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Medicamento {
    @Id
    @GeneratedValue
    private Long id;

    String Nombre;
    Integer Precio;

    Medicamento(){}
    Medicamento(String Nombre , Integer Precio ){
        this.Nombre = Nombre;
        this.Precio = Precio;
    }
}
