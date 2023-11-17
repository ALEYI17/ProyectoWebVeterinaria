package com.vetcare.proyecto.Repository;



import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.entities.Medicamento;
import com.vetcare.proyecto.entities.Tratamiento;
import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.repository.MascotaRepository;
import com.vetcare.proyecto.repository.MedicamentoRepositorio;
import com.vetcare.proyecto.repository.TratamientoRepositorio;
import com.vetcare.proyecto.repository.VeterinarioRepositorio;

@DataJpaTest
@RunWith(SpringRunner.class)
public class mascotaRepositoryTest {
    
    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    TratamientoRepositorio tratamientoRepositorio;

    @Autowired
    VeterinarioRepositorio veterinarioRepositorio;

    @Autowired
    MedicamentoRepositorio medicamentoRepositorio;

    @BeforeEach
    public void setUp(){
        mascotaRepository.save(new Mascota("Quinta","Siamese",14,5.0,"Cistitis","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Lolly","Persian",18,4.9,"Perionitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Ranice","Lykoi",10,4.3,"Virus de la leucemia felina","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Mattheus","Siamese",9,4.4,"Virus de la leucemia felina","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Cly","Maine Coon",15,4.4,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));

        veterinarioRepositorio.save(Veterinario.builder()
        .Nombre("prueba")
        .cedula("1234")
        .contrasena("1234")
        .especialidad("Nose")
        .foto("Nose")
        .activo(true)
        .build());

        medicamentoRepositorio.save(new Medicamento("ACOLAN", 2, 1, 4, 0));
    }

    @Test
    public void mascotaRepository_mascotasTratamiento_IsCero(){
        //arrange
        Tratamiento tratamiento = new Tratamiento(new Date(), 0);
        Long IDVeterinario = 1L;
        Long IDMedicamento = 1L;

        //act
        Mascota mascota = mascotaRepository.findById(1L).get();
        mascota.setMascotaTratamiento(true);
        mascotaRepository.save(mascota);
        tratamiento.setMascota(mascota);
        tratamiento.setVeterinario(veterinarioRepositorio.findById(IDVeterinario).get());
        tratamiento.setMedicamentos(medicamentoRepositorio.findById(IDMedicamento).get());
        tratamientoRepositorio.save(tratamiento);
        Long mascotasTratamiento = mascotaRepository.countMascotasConTratamientos();
        //assert
        Assertions.assertThat(mascotasTratamiento).isEqualTo(1L);
    }

}
