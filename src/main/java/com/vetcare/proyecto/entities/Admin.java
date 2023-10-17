package com.vetcare.proyecto.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Admin {

    // Declaración de variables de instancia
    String usuario;
    String contrasena;

    // Anotaciones para la entidad
    @Id
    @GeneratedValue
    private Long id;

    // Constructores
    public Admin(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Admin() {
    }

    // Métodos getter y setter para las variables de instancia
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Métodos getter y setter para el identificador (id)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
