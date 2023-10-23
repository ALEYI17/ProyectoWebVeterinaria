package com.vetcare.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Agregar un tratamiento nuevo
    @PostMapping("/add")
    public void anadirTratamiento(
        @RequestParam("MascotaId") String MascotaId,
        @RequestParam("VeterinarioId") String VeterinarioId,
        @RequestParam("MedicamentoId") String MedicamentoId,
        @RequestBody Tratamiento tratamiento
    ) {
        String inputId = VeterinarioId.trim();
        // Parseo de las ID a tipos numéricos
        Long veterinarioId = Long.parseLong(inputId);
        Long mascotaId = Long.parseLong(MascotaId);
        Long medicamentoId = Long.parseLong(MedicamentoId);

        // Obtener objetos relacionados desde los servicios
        Mascota mascota = mascotaServicio.GetById(mascotaId);
        Veterinario veterinario = veterinarioServicio.findVeterinarioById(veterinarioId);
        Medicamento medicamento = medicamentoServicio.findById(medicamentoId);

        // Configurar las relaciones en el objeto de tratamiento
        tratamiento.setMascota(mascota);
        tratamiento.setVeterinario(veterinario);
        tratamiento.setMedicamentos(medicamento);

        // Actualizar las unidades disponibles y vendidas del medicamento
        medicamentoServicio.actualizarUnidadesDisponiblesYVendidas(medicamentoId, 1);

        // Agregar el tratamiento
        tratamientoServicio.anadirTratamiento(tratamiento);
    }


    @GetMapping("/{id}/medicamento")
    public Medicamento getMedicamentoTratamiento(@PathVariable("id") String id){
        String id2 = id.trim();
        Long idFinal = Long.parseLong(id2);
        return tratamientoServicio.getMedicamentosByTratamiento(idFinal);

    }
}
