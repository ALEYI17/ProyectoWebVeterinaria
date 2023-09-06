package com.vetcare.proyecto.Exepciones;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(NotFoundException.class)
    public String error(Model model, NotFoundException exception){
        model.addAttribute("id", exception.getId());
        return "Errores/pagina_error";
    }
    
}
