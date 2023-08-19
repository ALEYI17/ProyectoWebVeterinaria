package com.vetcare.proyecto.entities;

public class Mascota {
    private String Nombre;
    private String Raza;
    private int Edad;
    private Double Peso;
    private String Enfermedad;
    private long ID;

    

    public Mascota(String nombre, String raza, int edad, Double peso, String enfermedad, long iD) {
        Nombre = nombre;
        Raza = raza;
        Edad = edad;
        Peso = peso;
        Enfermedad = enfermedad;
        ID = iD;
    }
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
    public int getEdad() {
        return Edad;
    }
    public void setEdad(int edad) {
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
    public long getID() {
        return ID;
    }
    public void setID(long iD) {
        ID = iD;
    }
    
    
    
}
