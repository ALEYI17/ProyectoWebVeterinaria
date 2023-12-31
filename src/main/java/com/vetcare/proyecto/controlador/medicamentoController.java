package com.vetcare.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetcare.proyecto.entities.Medicamento;
import com.vetcare.proyecto.service.MedicamentoServicio;

@RestController
@RequestMapping("/Medicamentos")
@CrossOrigin(origins = "http://localhost:4200")
public class medicamentoController {

    @Autowired
    MedicamentoServicio medicamentoServicio;

    // Este controlador maneja solicitudes relacionadas con medicamentos.

    // http://localhost:8090/Medicamentos/todos
    // Obtiene y devuelve una lista de todos los medicamentos disponibles.
    @GetMapping("/todos")
    public List<Medicamento> mostrarMedicamentos() {
        return medicamentoServicio.fiandAll();
    }

    //http://localhost:8090/Medicamentos/find/{id}
    //devuelve un medicamento por su id
    @GetMapping("/find/{id}")
    public Medicamento getMedicamentoById(@PathVariable("id") String id){

        Medicamento medicamento = medicamentoServicio.findById(Long.parseLong(id));
        return medicamento;
    }
}
