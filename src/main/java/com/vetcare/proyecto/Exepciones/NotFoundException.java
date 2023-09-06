package com.vetcare.proyecto.Exepciones;

// Declaración de una excepción personalizada llamada NotFoundException
public class NotFoundException extends RuntimeException {
    private Long id; // Un atributo privado que almacena el identificador relacionado con la excepción

    // Constructor que recibe un identificador (id) como argumento
    public NotFoundException(Long id) {
        this.id = id;
    }

    // Método getter para obtener el identificador (id)
    public Long getId() {
        return id;
    }

    // Método setter para establecer el identificador (id)
    public void setId(Long id) {
        this.id = id;
    }
}
