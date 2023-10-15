package com.vetcare.proyecto.entities;
// Importa las anotaciones de JPA para marcar esta clase como entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// Importa la clase java.sql.Date para trabajar con fechas
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Marca esta clase como una entidad de JPA
@Entity
public class Tratamiento {
    // Identificador único generado automáticamente por JPA
    @Id
    @GeneratedValue
    private Long id;

    // Atributos de la clase
    private Date Fecha;
    private Integer precio;
    private Boolean activo;

 

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

    // Constructor vacío necesario para JPA
    public Tratamiento() {
        // Constructor vacío
    }

    // Constructor de la clase Tratamiento que recibe parámetros
    public Tratamiento(Date Fecha, int precio) {
        this.Fecha = Fecha;
        this.precio = precio;
        this.activo = true;
    }

    // Métodos getter y setter para el identificador único
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Métodos getter y setter para el atributo "Fecha"
    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    // Métodos getter y setter para el atributo "precio"
    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    // Métodos getter y setter para la relación con la entidad Medicamento
    public Medicamento getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Medicamento medicamentos) {
        this.medicamentos = medicamentos;
    }

    // Métodos getter y setter para la relación con la entidad Mascota
    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    // Métodos getter y setter para la relación con la entidad Veterinario
    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
