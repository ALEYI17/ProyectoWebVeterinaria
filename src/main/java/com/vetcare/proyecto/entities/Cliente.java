package com.vetcare.proyecto.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Cliente {
    // Atributos de la clase Cliente
    String cedula;
    String nombre;
    String corre;
    String celular;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.ALL})
    private UserEntity user;
    
    // Identificador único de la entidad Cliente
    @Id
    @GeneratedValue
    private Long id;

    
    // Relación Uno a Muchos con la entidad Mascota

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    List<Mascota> MisMascotas = new ArrayList<>();
    
    // Constructor de la clase Cliente que recibe parámetros
    public Cliente(String cedula, String nombre, String corre, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.corre = corre;
        this.celular = celular;
    }

    // Constructor vacío necesario para JPA
    public Cliente (){}

    // Métodos getter y setter para los atributos de la clase
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorre() {
        return corre;
    }
    public void setCorre(String corre) {
        this.corre = corre;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    // Métodos getter y setter para la lista de Mascotas
    public List<Mascota> getMisMascotas() {
        return MisMascotas;
    }

    public void setMisMascotas(List<Mascota> misMascotas) {
        MisMascotas = misMascotas;
    }

    // Métodos getter y setter para el ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    
}