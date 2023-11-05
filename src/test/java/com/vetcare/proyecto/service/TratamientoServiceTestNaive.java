package com.vetcare.proyecto.service;


import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.vetcare.proyecto.entities.Tratamiento;
import com.vetcare.proyecto.service.TratamientoServicio;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
@SpringBootTest
public class TratamientoServiceTestNaive {
    @Autowired
    TratamientoServicio tratamientoServicio;

    @BeforeEach
    void init(){
        tratamientoServicio.anadirTratamiento(new Tratamiento(new Date(), 200));
        tratamientoServicio.anadirTratamiento(new Tratamiento(new Date(), 300));
        tratamientoServicio.anadirTratamiento(new Tratamiento(new Date(), 400));
        tratamientoServicio.anadirTratamiento(new Tratamiento(new Date(), 500));
        
    }

    @Test
    public void tratamientoServicio_CountTratamientosUltimoMes_Long(){

        //arrange
        Tratamiento tratamiento = new Tratamiento(new Date(), 200);
        Tratamiento tratamiento2 = new Tratamiento(new Date(), 300);
        //act
        tratamientoServicio.anadirTratamiento(tratamiento);
        tratamientoServicio.anadirTratamiento(tratamiento2);
        Long cantidad = tratamientoServicio.CountTratamientosUltimoMes();
        //assert
        Assertions.assertThat(cantidad).isEqualTo(6L);
    }

    @Test
    public void tratamientoServicio_anadirTratamiento_Tratamiento(){
         //arrange
        Tratamiento tratamiento = new Tratamiento(new Date(), 200);
        Tratamiento tratamiento2 = new Tratamiento(new Date(), 300);
        //act
        Tratamiento newTratamiento = tratamientoServicio.anadirTratamiento(tratamiento);
        Tratamiento newTratamiento2 = tratamientoServicio.anadirTratamiento(tratamiento2);

        //assert
        Assertions.assertThat(newTratamiento).isNotNull();
        Assertions.assertThat(newTratamiento2).isNotNull();
    }

    @Test
    public void tratamientoServicio_tratamientomedicamento_EmptyList() {
        // Llama al método que deseas probar
        List<Object[]> tratamientoMedicamento = tratamientoServicio.tratamientomedicamento();

        // Verifica que el resultado no sea nulo
        Assertions.assertThat(tratamientoMedicamento).isNotNull();

        // Verifica que la lista esté vacía
        Assertions.assertThat(tratamientoMedicamento).isEmpty();
    }
}

