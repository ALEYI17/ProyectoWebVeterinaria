package com.vetcare.proyecto.entities;
// Importa las anotaciones de JPA para marcar esta clase como entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Marca esta clase como una entidad de JPA
@Entity
public class Veterinario {
    // Atributos de la clase
    private String cedula;
    private String contrasena;
    private String especialidad;
    private String foto;
    private Integer numeroDeAtenciones;

    // Identificador único generado automáticamente por JPA
    @Id
    @GeneratedValue
    private Long id;

    // Métodos getter y setter para cada atributo
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getNumeroDeAtenciones() {
        return numeroDeAtenciones;
    }

    public void setNumeroDeAtenciones(Integer numeroDeAtenciones) {
        this.numeroDeAtenciones = numeroDeAtenciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Constructores
    public Veterinario() {
        // Constructor vacío
    }

    public Veterinario(String cedula, String contrasena, String especialidad, String foto, int numeroDeAtenciones) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.foto = foto;
        this.numeroDeAtenciones = numeroDeAtenciones;
    }
}
