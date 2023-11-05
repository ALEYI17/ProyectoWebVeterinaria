package com.vetcare.proyecto.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {
    // Atributos de la clase Cliente
    String cedula;
    String nombre;
    String corre;
    String celular;
    
    // Identificador único de la entidad Cliente
    @Id
    @GeneratedValue
    private Long id;

    
    // Relación Uno a Muchos con la entidad Mascota

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    List<Mascota> MisMascotas = new ArrayList<>();
    
    // Constructor de la clase Cliente que recibe parámetros
    public Cliente(String cedula, String nombre, String corre, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.corre = corre;
        this.celular = celular;
    }

   
}
