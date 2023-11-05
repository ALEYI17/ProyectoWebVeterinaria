package com.vetcare.proyecto.entities;
import jakarta.persistence.CascadeType;
// Importa las anotaciones de JPA para marcar esta clase como entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

// Importa la clase de la relación uno a muchos con Tratamiento
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Marca esta clase como una entidad de JPA
@Entity
@Data
@NoArgsConstructor
public class Mascota {
    // Atributos de la clase Mascota
    private String Nombre;
    private String Raza;
    private Integer Edad;
    private Double Peso;

    private String Enfermedad;
    private String Foto;

    private boolean mascotaTratamiento;



    // Identificador único de la entidad Mascota
    @Id
    @GeneratedValue
    private Long ID;
    
   
    // Relación Muchos a Uno con la entidad Cliente
    @JsonIgnore
    @ManyToOne
    private Cliente cliente;

   
    // Relación Uno a Muchos con la entidad Tratamiento, mapeada por el atributo "mascota" en Tratamiento
    @JsonIgnore
    @OneToMany(mappedBy = "mascota", cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Tratamiento> tratamientos;

    // Constructor de la clase Mascota que recibe parámetros
    public Mascota(String nombre, String raza, Integer edad, Double peso, String enfermedad, String foto) {
        Nombre = nombre;
        Raza = raza;
        Edad = edad;
        Peso = peso;
        Enfermedad = enfermedad;
        Foto = foto;
    
    }


}
