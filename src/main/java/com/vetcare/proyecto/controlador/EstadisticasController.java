package com.vetcare.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetcare.proyecto.entities.Medicamento;
import com.vetcare.proyecto.service.MascotaServicio;
import com.vetcare.proyecto.service.MedicamentoServicio;
import com.vetcare.proyecto.service.TratamientoServicio;
import com.vetcare.proyecto.service.VeterinarioServicio;

@RestController
@RequestMapping("/estadisticas")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadisticasController {
    @Autowired
    VeterinarioServicio veterinarioservicio;

    @Autowired
    MedicamentoServicio medicamentoservicio;

    @Autowired
    MascotaServicio mascotaservicio;

    @Autowired
    TratamientoServicio tratamientoservicio;


    @GetMapping("/vetactivos")
    public Long numeroDeVeterinariosActivos(){return veterinarioservicio.CountVeterinariosActivos();}

    @GetMapping("/vetinactivos")
    public Long numeroDeVeterinariosIneactivos(){return veterinarioservicio.CountVeterinariosInactivos();}


    @GetMapping("/countmascotas")
    public Long numeroMascotas(){return mascotaservicio.CountMascotas();}

    @GetMapping("/tratamientosmes")
    public Long tratamientosXmes(){return tratamientoservicio.CountTratamientosUltimoMes();}

    @GetMapping("/tratamientomedicamento")
    public List<Object[]> obtenerCantidadTratamientosPorTipoEnUltimoMes(){
        return tratamientoservicio.tratamientomedicamento();
    }

    @GetMapping("/totalventas")
    public Long ventasTotales(){return medicamentoservicio.ventasTotales();}

    @GetMapping("/gananciastotales")
    public Long gananciasTotales(){return medicamentoservicio.gananciasTotales();}

    @GetMapping("/Tratamientos")
    public List<Object[]> mascotasConTratamientosActivos(){return mascotaservicio.MascotasTratamientosActivos();}

 @GetMapping("/topmedicamentos")
    public List<Medicamento> topMedicamentos(){return medicamentoservicio.top3medicaMentos();}


}
