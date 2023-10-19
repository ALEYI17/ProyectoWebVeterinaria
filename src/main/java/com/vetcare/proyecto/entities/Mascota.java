package com.vetcare.proyecto.entities;
import jakarta.persistence.CascadeType;
// Importa las anotaciones de JPA para marcar esta clase como entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

// Importa la clase de la relación uno a muchos con Tratamiento
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Marca esta clase como una entidad de JPA
@Entity
public class Mascota {
    // Atributos de la clase Mascota
    private String Nombre;
    private String Raza;
    private Integer Edad;
    private Double Peso;

    private String Enfermedad;
    private String Foto;



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

    // Constructor vacío necesario para JPA
    public Mascota (){}

    // Métodos getter y setter para los atributos de la clase
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getRaza() {
        return Raza;
    }
    public void setRaza(String raza) {
        Raza = raza;
    }
    public Integer getEdad() {
        return Edad;
    }
    public void setEdad(Integer edad) {
        Edad = edad;
    }
    public Double getPeso() {
        return Peso;
    }
    public void setPeso(Double peso) {
        Peso = peso;
    }
    public String getEnfermedad() {
        return Enfermedad;
    }
    public void setEnfermedad(String enfermedad) {
        Enfermedad = enfermedad;
    }
    public Long getID() {
        return ID;
    }
    public void setID(Long iD) {
        ID = iD;
    }
    public String getFoto() {
        return Foto;
    }
    public void setFoto(String foto) {
        Foto = foto;
    }

    // Métodos getter y setter para la relación con Cliente
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Métodos getter y setter para la relación con Tratamiento
    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }
    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
}
