package com.vetcare.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/todos")
    public List<Medicamento> mostrarMedicamentos(){
        return medicamentoServicio.fiandAll();
    }
    
}
