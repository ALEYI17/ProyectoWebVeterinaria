package com.vetcare.proyecto.entities;
// Importa las anotaciones de JPA para marcar esta clase como entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

// Importa la clase java.sql.Date para trabajar con fechas
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Marca esta clase como una entidad de JPA
@Entity
@Data
@NoArgsConstructor
public class Tratamiento {
    // Identificador único generado automáticamente por JPA
    @Id
    @GeneratedValue
    private Long id;

    // Atributos de la clase
    private Date Fecha;
    private Integer precio;

 

    // Relación Uno a Muchos con la entidad Medicamento
    @JsonIgnore
    @ManyToOne
    private Medicamento medicamentos;

    // Relación Muchos a Uno con la entidad Mascota
    @JsonIgnore
    @ManyToOne
    private Mascota mascota;

    // Relación Muchos a Uno con la entidad Veterinario
    @JsonIgnore
    @ManyToOne
    private Veterinario veterinario;



    // Constructor de la clase Tratamiento que recibe parámetros
    public Tratamiento(Date Fecha, int precio) {
        this.Fecha = Fecha;
        this.precio = precio;
    }



}
