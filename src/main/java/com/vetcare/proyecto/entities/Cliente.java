package com.vetcare.proyecto.entities;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    String cedula;
    String nombre;
    String corre;
    String celular;
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "cliente")
    ArrayList<Mascota> MisMascotas = new ArrayList<>();
    
    public Cliente(String cedula, String nombre, String corre, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.corre = corre;
        this.celular = celular;
    }

    public Cliente (){}

    
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
    public ArrayList<Mascota> getMisMascotas() {
        return MisMascotas;
    }

    public void setMisMascotas(ArrayList<Mascota> misMascotas) {
        MisMascotas = misMascotas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
