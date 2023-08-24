package com.vetcare.proyecto.entities;

public class Cliente {
    String cedula;
    String nombre;
    String corre;
    String celular;

    public Cliente(String cedula, String nombre, String corre, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.corre = corre;
        this.celular = celular;
    }
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
    
}
