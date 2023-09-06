package com.vetcare.proyecto.entities;

// Importa las anotaciones de JPA para marcar esta clase como entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// Marca esta clase como una entidad de JPA
@Entity
public class Medicamento {
    // Identificador único generado automáticamente por JPA
    @Id
    @GeneratedValue
    private Long id;

    // Atributos de la clase
    private String Nombre;
    private Integer Precio;

    // Relación Muchos a Uno con la entidad Tratamiento
    @ManyToOne
    private Tratamiento tratamiento;

    // Constructor vacío necesario para JPA
    public Medicamento() {
        // Constructor vacío
    }

    // Constructor de la clase Medicamento que recibe parámetros
    public Medicamento(String Nombre, Integer Precio) {
        this.Nombre = Nombre;
        this.Precio = Precio;
    }

    // Métodos getter y setter para el identificador único
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Métodos getter y setter para el atributo "Nombre"
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    // Métodos getter y setter para el atributo "Precio"
    public Integer getPrecio() {
        return Precio;
    }

    public void setPrecio(Integer Precio) {
        this.Precio = Precio;
    }

    // Métodos getter y setter para la relación con la entidad Tratamiento
    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
}
