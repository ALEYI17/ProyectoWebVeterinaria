package com.vetcare.proyecto.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tratamiento {
    @Id
    @GeneratedValue
    private Long id;

    Date Fecha;
    Integer precio;

    Tratamiento(){}

    Tratamiento(Date Fecha, int precio){
        this.Fecha = Fecha;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    
    
}
