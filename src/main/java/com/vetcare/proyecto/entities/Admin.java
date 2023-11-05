package com.vetcare.proyecto.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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


}
