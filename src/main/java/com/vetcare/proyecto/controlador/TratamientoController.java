package com.vetcare.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.entities.Medicamento;
import com.vetcare.proyecto.entities.Tratamiento;
import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.service.MascotaServicio;
import com.vetcare.proyecto.service.MedicamentoServicio;
import com.vetcare.proyecto.service.TratamientoServicio;
import com.vetcare.proyecto.service.VeterinarioServicio;



@RestController
@RequestMapping("/Tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {

    @Autowired
    TratamientoServicio tratamientoServicio;
    @Autowired
    MascotaServicio mascotaServicio;
    @Autowired
    VeterinarioServicio veterinarioServicio;
    @Autowired
    MedicamentoServicio medicamentoServicio;

    @PostMapping("/add")
    public void anadirTratamiento( @RequestParam("MascotaId") String MascotaId, @RequestParam("VeterinarioId") String VeterinarioId
    ,@RequestParam("MedicamentoId") String MedicamentoId ,@RequestBody Tratamiento tratamiento ){
        String inputId = VeterinarioId.trim(); // Trim leading and trailing spaces
        Long veterinarioId = Long.parseLong(inputId);
        Mascota mascota = mascotaServicio.GetById(Long.parseLong(MascotaId));
        Veterinario veterinario = veterinarioServicio.findVeterinarioById(veterinarioId);
        Medicamento medicamento = medicamentoServicio.findById(Long.parseLong(MedicamentoId));
        tratamiento.setMascota(mascota);
        tratamiento.setVeterinario(veterinario);
        tratamiento.setMedicamentos(medicamento);
        medicamentoServicio.actualizarUnidadesDisponiblesYVendidas(Long.parseLong(MedicamentoId), 1);
        tratamientoServicio.anadirTratamiento(tratamiento);
        
    }

    @PostMapping("/Desactivar")
    public void DesactivarTratamiento(@RequestBody Tratamiento tratamiento){
        tratamientoServicio.cambiarEstadoActivo(tratamiento.getId(), false);
    }
    
}
