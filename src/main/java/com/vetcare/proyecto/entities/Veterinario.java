package com.vetcare.proyecto.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
// Importa las anotaciones de JPA para marcar esta clase como entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// Marca esta clase como una entidad de JPA
@Entity
public class Veterinario {

    // Atributos de la clase
    private String Nombre;
    private String cedula; // Cédula del veterinario
    private String contrasena; // Contraseña del veterinario
    private String especialidad; // Especialidad del veterinario
    private String foto; // Ruta de la foto del veterinario
   private boolean activo;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    // Identificador único generado automáticamente por JPA
    @Id
    @GeneratedValue
    private Long id; // Identificador único del veterinario

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario" , cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    List<Tratamiento> tratamientos; // Lista de tratamientos relacionados con este veterinario

     // Constructores

    // Constructor vacío
    public Veterinario() {
        // Constructor vacío
    }

    // Constructor con parámetros para inicializar los atributos
    public Veterinario(String Nombre,String cedula, String contrasena, String especialidad, String foto,boolean activo) {
        this.Nombre = Nombre;
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.foto = foto;
        this.activo = activo;
    }

    // Métodos getter y setter para cada atributo

    // Getter para obtener la cédula del veterinario
    public String getCedula() {
        return cedula;
    }

    // Setter para establecer la cédula del veterinario
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    // Getter para obtener la contraseña del veterinario
    public String getContrasena() {
        return contrasena;
    }

    // Setter para establecer la contraseña del veterinario
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Getter para obtener la especialidad del veterinario
    public String getEspecialidad() {
        return especialidad;
    }

    // Setter para establecer la especialidad del veterinario
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Getter para obtener la ruta de la foto del veterinario
    public String getFoto() {
        return foto;
    }

    // Setter para establecer la ruta de la foto del veterinario
    public void setFoto(String foto) {
        this.foto = foto;
    }


    // Getter para obtener el identificador único del veterinario
    public Long getId() {
        return id;
    }

    // Setter para establecer el identificador único del veterinario
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
}
