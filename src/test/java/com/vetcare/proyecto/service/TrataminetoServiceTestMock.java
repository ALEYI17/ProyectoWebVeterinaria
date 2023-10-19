package com.vetcare.proyecto.Service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.vetcare.proyecto.entities.Tratamiento;
import com.vetcare.proyecto.repository.MedicamentoRepositorio;
import com.vetcare.proyecto.repository.TratamientoRepositorio;
import com.vetcare.proyecto.service.TratamientoServicioimpl;


@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TrataminetoServiceTestMock {

    @Mock
    private TratamientoRepositorio tratamientoRepo;

    @Mock
    private MedicamentoRepositorio medicamentoRepo;

    
    @Mock
    private MedicamentoRepositorio mascotaRepo;

        
    @Mock
    private MedicamentoRepositorio veterinarioRepo;

    @InjectMocks
    private TratamientoServicioimpl tratamientoserice;


    
    @Test
    public void TratamientoService_createTratamiento_Tratamiento(){
    
        //arrange
        Tratamiento tratamiento = new Tratamiento(new Date(), 200);

        when(tratamientoRepo.save(tratamiento)).thenReturn(tratamiento);

        //act
        Tratamiento tratamientoTest = tratamientoserice.anadirTratamiento(tratamiento);

        //assert
        Assertions.assertThat(tratamientoTest).isNotNull();
    }


    @Test
    public void  TratamientoService_tratamientoUltimoMes_Tratamiento(){


        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicioMes = fechaActual.minusMonths(1).withDayOfMonth(1);
        LocalDate fechaFinMes = fechaActual.withDayOfMonth(fechaActual.lengthOfMonth());

        Date fechaInicio = Date.from(fechaInicioMes.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(fechaFinMes.atStartOfDay(ZoneId.systemDefault()).toInstant());

        when(tratamientoRepo.countTratamientosEnUltimoMes(fechaInicio, fechaFin)).thenReturn(5L);


        Long TramientsEnMes = tratamientoserice.CountTratamientosUltimoMes();

        Assertions.assertThat(TramientsEnMes).isEqualTo(5L);

    }
    
    @Test
    public void TratamientoService_tratamientoMedicamento_Tratamiento(){

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicioMes = fechaActual.minusMonths(1).withDayOfMonth(1);
        LocalDate fechaFinMes = fechaActual.withDayOfMonth(fechaActual.lengthOfMonth());

        Date fechaInicio = Date.from(fechaInicioMes.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(fechaFinMes.atStartOfDay(ZoneId.systemDefault()).toInstant());


        List<Object[]> mockResponse = Arrays.asList(
            new Object[]{"ALBIOTIC", 1},
            new Object[]{"AMOXIBACTIN", 1},
            new Object[]{"APSASOL", 1}
        );
        when(tratamientoRepo.countTratamientosPorTipoEnUltimoMes(fechaInicio, fechaFin)).thenReturn(mockResponse);

        List<Object[]> result = tratamientoserice.tratamientomedicamento();

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(mockResponse.size());

    }
}
