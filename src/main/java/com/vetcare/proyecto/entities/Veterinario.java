package com.vetcare.proyecto.entities;
import java.util.List;

// Importa las anotaciones de JPA para marcar esta clase como entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// Marca esta clase como una entidad de JPA
@Entity
public class Veterinario {
    // Atributos de la clase
    private String cedula; // Cédula del veterinario
    private String contrasena; // Contraseña del veterinario
    private String especialidad; // Especialidad del veterinario
    private String foto; // Ruta de la foto del veterinario
    private Integer numeroDeAtenciones; // Número de atenciones que ha realizado el veterinario

    // Identificador único generado automáticamente por JPA
    @Id
    @GeneratedValue
    private Long id; // Identificador único del veterinario

    @OneToMany(mappedBy = "veterinario")
    List<Tratamiento> tratamientos; // Lista de tratamientos relacionados con este veterinario

     // Constructores

    // Constructor vacío
    public Veterinario() {
        // Constructor vacío
    }

    // Constructor con parámetros para inicializar los atributos
    public Veterinario(String cedula, String contrasena, String especialidad, String foto, int numeroDeAtenciones) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.foto = foto;
        this.numeroDeAtenciones = numeroDeAtenciones;
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

    // Getter para obtener el número de atenciones del veterinario
    public Integer getNumeroDeAtenciones() {
        return numeroDeAtenciones;
    }

    // Setter para establecer el número de atenciones del veterinario
    public void setNumeroDeAtenciones(Integer numeroDeAtenciones) {
        this.numeroDeAtenciones = numeroDeAtenciones;
    }

    // Getter para obtener el identificador único del veterinario
    public Long getId() {
        return id;
    }

    // Setter para establecer el identificador único del veterinario
    public void setId(Long id) {
        this.id = id;
    }

   
}
