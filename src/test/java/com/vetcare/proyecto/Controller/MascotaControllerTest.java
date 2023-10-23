package com.vetcare.proyecto.Controller;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;

import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetcare.proyecto.controlador.MascotaController;
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.service.ClienteServicio;
import com.vetcare.proyecto.service.MascotaServicio;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = MascotaController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class MascotaControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MascotaServicio mascotaService;

    @MockBean
    private ClienteServicio clienteServicio;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void MascotasController_findaAll_listaMascotas()  throws Exception{

        Mascota mascota1 = new Mascota("Mascota1", "Raza1", 3, 5.0, "Enfermedad1", "foto1.jpg");
        Mascota mascota2 = new Mascota("Mascota2", "Raza2", 2, 4.5, "Enfermedad2", "foto2.jpg");

        // Simular el comportamiento del servicio al llamar a findAll()
        when(mascotaService.GetAll()).thenReturn(Arrays.asList(mascota1, mascota2));

        
        ResultActions reponse = mockMvc.perform(get("/Mascota/todas"));

        ResultMatcher sizeMatcher = jsonPath("$.size()").value(2);

        reponse.andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(sizeMatcher);


    }

    @Test
    public void MascotasController_AgregarMascota_Mascotas()  throws Exception{


        Mascota mascota1 = new Mascota("Mascota1", "Raza1", 3, 5.0, "Enfermedad1", "foto1.jpg");
        Cliente cliente = new Cliente("5602222623501237","Crin Dottridge","cdottridge0@bravesites.com","184-683-8032");

        when(mascotaService.addMascota(Mockito.any(Mascota.class))).thenReturn(mascota1);
        when(clienteServicio.GetById(1L)).thenReturn(cliente);

        // mascota1.setCliente(cliente);
        ResultActions response = mockMvc.perform(post("/Mascota/agregar").param("clientId", "1").contentType("application/json")
            .content(objectMapper.writeValueAsString(mascota1)));

        response.andExpect(status().isCreated())
        .andExpect(content().contentType("application/json"))
        //
        .andExpect(jsonPath("$.nombre").value("Mascota1"))
        .andExpect(jsonPath("$.enfermedad").value(mascota1.getEnfermedad()))
        .andExpect(jsonPath("$.edad").value(mascota1.getEdad()))
        .andExpect(jsonPath("$.raza").value(mascota1.getRaza()))
        .andExpect(jsonPath("$.peso").value(mascota1.getPeso()));


    }

    
    @Test
    public void MascotasController_findaById_Mascotas()  throws Exception{

        Mascota mascota1 = new Mascota("Mascota1", "Raza1", 3, 5.0, "Enfermedad1", "foto1.jpg");
        when(mascotaService.addMascota(mascota1)).thenReturn(mascota1);
        when(mascotaService.GetById(1L)).thenReturn(mascota1);
        ResultActions response = mockMvc.perform(get("/Mascota/find").param("id", "1"));

        response.andExpect(status().isOk()).andExpect(jsonPath("$.nombre").value("Mascota1"));
    }

    
    @Test
    public void MascotasController_findaById_noEncotnrado()  throws Exception{

        when(mascotaService.GetById(anyLong())).thenReturn(null);
        ResultActions response = mockMvc.perform(get("/Mascota/find/{id}", 45));

        response.andExpect(status().isNotFound());
    }


    @Test
    public void MascotasController_DeleteMascota_String()  throws Exception{

        doNothing().when(mascotaService).removeMascota(1L);
        ResultActions response = mockMvc.perform(delete("/Mascota/delete/{id}", 1));

        response.andExpect(status().isNoContent())
        .andExpect(content().string("DELETED"));
        
    }

    @Test
    public void MascotasController_ActualizarMascota_Mascota()  throws Exception{

    Long mascotaId = 1L;
    Cliente cliente = new Cliente("5602222623501237", "Crin Dottridge", "cdottridge0@bravesites.com", "184-683-8032");
    Mascota updatedMascota = new Mascota("MascotaActualizada", "RazaActualizada", 4, 6.0, "EnfermedadActualizada", "foto_actualizada.jpg");

    // Mock the behavior of your service
    when(clienteServicio.GetById(Mockito.any(Long.class))).thenReturn(cliente);
    when(mascotaService.updateMascota(Mockito.any(Mascota.class))).thenReturn(updatedMascota);

    // Perform the request to update the Mascota
    ResultActions response = mockMvc.perform(put("/Mascota/update/{id}", mascotaId)
            .param("cliente.id", "1")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(updatedMascota)));


    response.andExpect(status().isOk())
    .andExpect(content().contentType("application/json"))
    .andExpect(jsonPath("$.nombre").value(updatedMascota.getNombre()))
    .andExpect(jsonPath("$.enfermedad").value(updatedMascota.getEnfermedad()))
    .andExpect(jsonPath("$.edad").value(updatedMascota.getEdad()))
    .andExpect(jsonPath("$.raza").value(updatedMascota.getRaza()))
    .andExpect(jsonPath("$.peso").value(updatedMascota.getPeso()));
    
    }

}
