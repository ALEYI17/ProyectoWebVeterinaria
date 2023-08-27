package com.vetcare.proyecto.entities;

import java.util.ArrayList;

public class Cliente {
    String cedula;

    String nombre;
    String corre;
    String celular;
    ArrayList<Integer> MisMascotas;
    
    public Cliente(String cedula, String nombre, String corre, String celular, ArrayList<Integer> misMascotas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.corre = corre;
        this.celular = celular;
        MisMascotas = misMascotas;
    }

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
    public ArrayList<Integer> getMisMascotas() {
        return MisMascotas;
    }

    public void setMisMascotas(ArrayList<Integer> misMascotas) {
        MisMascotas = misMascotas;
    }
}
