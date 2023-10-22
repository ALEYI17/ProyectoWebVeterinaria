package com.vetcare.proyecto.Repository;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.Assertions;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vetcare.proyecto.entities.Medicamento;

import com.vetcare.proyecto.repository.MedicamentoRepositorio;


@DataJpaTest
@RunWith(SpringRunner.class)
public class medicamentoRepositoryTest {
    @Autowired
    MedicamentoRepositorio medicamentoRepositorio;


    @BeforeEach
    public void setUp() throws IOException{
        leerMedicamentosDesdeExcel();

    }

    @Test
    public void medicamentoRepositorio_totalDeVentas_Long(){
        //arrange
       Medicamento medicamento = medicamentoRepositorio.findById(1L).get();

        //act
        medicamento.setUnidadesVendidas(1);
        medicamentoRepositorio.save(medicamento);
        Long ventas = medicamentoRepositorio.totalDeVentas();
        //assert
        Assertions.assertThat(ventas).isGreaterThan(0);
        Assertions.assertThat(ventas).isEqualTo(1);
    }


    
    public void leerMedicamentosDesdeExcel() throws IOException {
        

        try (FileInputStream archivo = new FileInputStream("MEDICAMENTOS_VETERINARIA.xlsx");
             Workbook workbook = new XSSFWorkbook(archivo)) {

            Sheet hoja = workbook.getSheetAt(0); // Suponiendo que los datos están en la primera hoja

            Iterator<Row> filaIterator = hoja.iterator();
            filaIterator.next(); // Saltar la primera fila (encabezados)

            while (filaIterator.hasNext()) {
                Row fila = filaIterator.next();
                Iterator<Cell> celdaIterator = fila.iterator();

                String nombre = celdaIterator.next().getStringCellValue();
                double precioVenta = celdaIterator.next().getNumericCellValue();
                double precioCompra = celdaIterator.next().getNumericCellValue();
                int unidadesDisponibles = (int) celdaIterator.next().getNumericCellValue();
                int unidadesVendidas = (int) celdaIterator.next().getNumericCellValue();

                // Crea un nuevo objeto Medicamento y agrégalo a la lista
                Medicamento medicamento = new Medicamento(nombre, precioVenta, precioCompra, unidadesDisponibles, unidadesVendidas);
                medicamentoRepositorio.save(medicamento);
            }
        }

        
    }
}
