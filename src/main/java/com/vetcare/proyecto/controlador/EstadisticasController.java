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
    // Inyección de servicios necesarios
    @Autowired
    VeterinarioServicio veterinarioservicio;

    @Autowired
    MedicamentoServicio medicamentoservicio;

    @Autowired
    MascotaServicio mascotaservicio;

    @Autowired
    TratamientoServicio tratamientoservicio;

    // http://localhost:8090/estadisticas/vetactivos
    // Obtiene el número de veterinarios activos
    @GetMapping("/vetactivos")
    public Long numeroDeVeterinariosActivos(){
        return veterinarioservicio.CountVeterinariosActivos();
    }

    // http://localhost:8090/estadisticas/vetinactivos
    // Obtiene el número de veterinarios inactivos
    @GetMapping("/vetinactivos")
    public Long numeroDeVeterinariosIneactivos(){
        return veterinarioservicio.CountVeterinariosInactivos();
    }

    // http://localhost:8090/estadisticas/countmascotas
    // Obtiene el número total de mascotas
    @GetMapping("/countmascotas")
    public Long numeroMascotas(){
        return mascotaservicio.CountMascotas();
    }

    // http://localhost:8090/estadisticas/tratamientosmes
    // Obtiene el número de tratamientos en el último mes
    @GetMapping("/tratamientosmes")
    public Long tratamientosXmes(){
        return tratamientoservicio.CountTratamientosUltimoMes();
    }

    // http://localhost:8090/estadisticas/tratamientomedicamento
    // Obtiene una lista de cantidades de tratamientos por tipo en el último mes
    @GetMapping("/tratamientomedicamento")
    public List<Object[]> obtenerCantidadTratamientosPorTipoEnUltimoMes(){
        return tratamientoservicio.tratamientomedicamento();
    }

    // http://localhost:8090/estadisticas/totalventas
    // Obtiene el total de ventas de medicamentos
    @GetMapping("/totalventas")
    public Long ventasTotales(){
        return medicamentoservicio.ventasTotales();
    }

    // http://localhost:8090/estadisticas/gananciastotales
    // Obtiene el total de ganancias por ventas de medicamentos
    @GetMapping("/gananciastotales")
    public Long gananciasTotales(){
        return medicamentoservicio.gananciasTotales();
    }

    // http://localhost:8090/estadisticas/TratamientosActivos
    // Obtiene una lista de mascotas con tratamientos activos
    @GetMapping("/TratamientosActivos")
    public Long mascotasConTratamientosActivos(){
        return mascotaservicio.MascotasTratamientosActivos();
    }

    // http://localhost:8090/estadisticas/topmedicamentos
    // Obtiene una lista de los 3 medicamentos más populares
    @GetMapping("/topmedicamentos")
    public List<Medicamento> topMedicamentos(){
        return medicamentoservicio.top3medicaMentos();
    }
}
