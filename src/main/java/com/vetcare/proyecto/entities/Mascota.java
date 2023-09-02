package com.vetcare.proyecto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Mascota {
    private String Nombre;
    private String Raza;
    private Integer Edad;
    private Double Peso;
    private String Enfermedad;

    @Id
    @GeneratedValue
    private Long ID;
    @ManyToOne
    private Cliente cliente;

    

    public Mascota(String nombre, String raza, Integer edad, Double peso, String enfermedad) {
        Nombre = nombre;
        Raza = raza;
        Edad = edad;
        Peso = peso;
        Enfermedad = enfermedad;
    }
    public Mascota (){}
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
    
    
    
}
