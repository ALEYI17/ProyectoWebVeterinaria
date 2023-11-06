package com.vetcare.proyecto.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
// Importa las anotaciones de JPA para marcar esta clase como entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Marca esta clase como una entidad de JPA
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Veterinario {

    // Atributos de la clase
    private String Nombre;
    private String cedula; // Cédula del veterinario
    private String contrasena; // Contraseña del veterinario
    private String especialidad; // Especialidad del veterinario
    private String foto; // Ruta de la foto del veterinario
   private boolean activo;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    // Identificador único generado automáticamente por JPA
    @Id
    @GeneratedValue
    private Long id; // Identificador único del veterinario

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario" , cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    List<Tratamiento> tratamientos; // Lista de tratamientos relacionados con este veterinario

     // Constructores



    // Constructor con parámetros para inicializar los atributos
    public Veterinario(String Nombre,String cedula, String contrasena, String especialidad, String foto,boolean activo) {
        this.Nombre = Nombre;
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.foto = foto;
        this.activo = activo;
    }

  

   
}
