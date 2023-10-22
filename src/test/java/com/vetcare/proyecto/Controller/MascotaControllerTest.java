package com.vetcare.proyecto.Controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetcare.proyecto.controlador.MascotaController;
import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.service.ClienteServicio;
import com.vetcare.proyecto.service.MascotaServicio;
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
    public void MascotasController_findaById_Mascotas()  throws Exception{
        
    }

    @Test
    public void MascotasController_AgregarMascota_Mascotas()  throws Exception{
        
    }

    @Test
    public void MascotasController_DeleteMascota_String()  throws Exception{
        
    }

    @Test
    public void MascotasController_ActualizarMascota_Mascota()  throws Exception{
        
    }

}
