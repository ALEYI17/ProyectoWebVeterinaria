package com.vetcare.proyecto.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Medicamento {
    @Id
    @GeneratedValue
    private Long id;
     // Atributos de la entidad
    private String nombre;
    private double precioVenta; // Cambiado a double para representar valores en dólares
    private double precioCompra; // Cambiado a double para representar valores en dólares
    private int unidadesDisponibles;
    private int unidadesVendidas;

     // Relación uno a muchos con la entidad Tratamiento
    @JsonIgnore
    @OneToMany(mappedBy = "medicamentos")
    private List<Tratamiento> tratamiento;

     // Constructores

    public Medicamento(String nombre, double precioVenta, double precioCompra, int unidadesDisponibles, int unidadesVendidas) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesVendidas = unidadesVendidas;
    }


}
