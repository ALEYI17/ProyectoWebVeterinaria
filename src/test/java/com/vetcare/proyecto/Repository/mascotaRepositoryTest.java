package com.vetcare.proyecto.Repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.repository.MascotaRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class mascotaRepositoryTest {
    
    @Autowired
    MascotaRepository mascotaRepository;

    @BeforeEach
    public void setUp(){
        mascotaRepository.save(new Mascota("Quinta","Siamese",14,5.0,"Cistitis","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Lolly","Persian",18,4.9,"Perionitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Ranice","Lykoi",10,4.3,"Virus de la leucemia felina","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Mattheus","Siamese",9,4.4,"Virus de la leucemia felina","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Cly","Maine Coon",15,4.4,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
    }

    @Test
    public void mascotaRepository_mascotasTratamiento_IsCero(){
        //arrange
        Mascota mascota =mascotaRepository.save(new Mascota("Quinta2","Siamese",14,5.0,"Cistitis","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        //act
        Long mascotasTratamiento = mascotaRepository.countMascotasConTratamientos();
        //assert
        Assertions.assertThat(mascotasTratamiento).isEqualTo(0);
    }

}
