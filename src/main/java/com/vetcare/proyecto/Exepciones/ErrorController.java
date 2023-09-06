package com.vetcare.proyecto.Exepciones;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    // Método para manejar excepciones del tipo NotFoundException
    @ExceptionHandler(NotFoundException.class)
    public String error(Model model, NotFoundException exception){
        // Agregar el identificador (id) de la excepción al modelo para su visualización en la vista
        model.addAttribute("id", exception.getId());
        
        // Devolver el nombre de la vista de error ("Errores/pagina_error") que se mostrará al usuario
        return "Errores/pagina_error";
    }
}
