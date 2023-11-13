package com.vetcare.proyecto.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    // Constructores
    public Admin(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }


}
