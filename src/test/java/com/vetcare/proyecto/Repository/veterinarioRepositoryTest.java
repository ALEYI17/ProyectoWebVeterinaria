package com.vetcare.proyecto.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.repository.VeterinarioRepositorio;
import org.junit.jupiter.api.Test;

@DataJpaTest
@RunWith(SpringRunner.class)
public class veterinarioRepositoryTest {

    @Autowired
    VeterinarioRepositorio veterinarioRepositorio;

    @BeforeEach
    public void setUp(){
        veterinarioRepositorio.save(new Veterinario("prueba","123", "123", "Nose", "Nose",true));
        veterinarioRepositorio.save(new Veterinario("Lynelle Charsley", "9045730128", "nH6?tI)#e", "Imagenología", "https://images.ecestaticos.com/ciN9hN7qsu5JOcrGdMngWhCHs8Y=/0x70:1716x1040/1200x1200/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F8db%2F8b6%2Faa5%2F8db8b6aa54b585253e15f79a68447aeb.jpg",true));
        veterinarioRepositorio.save(new Veterinario("Ianthe Jordine", "1443103554", "iB7,*K+Pi6a1q", "Rehabilitación", "https://amigodoctor.com/inicio/drs/adrian.jpg",true));
        veterinarioRepositorio.save(new Veterinario("Jayme Novotne", "3844360055", "zF1%7D9~f", "Oncología", "https://yt3.googleusercontent.com/ytc/APkrFKYQtHv2GYhbAQkrTRknWk6YVrDLLZk1YovsUcT0Aw=s900-c-k-c0x00ffffff-no-rj",true));
        veterinarioRepositorio.save(new Veterinario("Harrietta Wheatcroft", "9928747656", "fV5.}6BrqQ+Ma&+", "Rehabilitación", "https://ic.c4assets.com/brands/the-good-doctor/b24d15b7-bba0-4939-bf45-e893dd5d46fa.jpg?interpolation=progressive-bicubic&output-format=jpeg&output-quality=90{&resize}",true));

    }

    @Test
    public void veterinarioRepositorio_findVeterinarioByCedulaAndContrasena_NotNull(){

        //arrange
        String Cedula = "9045730128";
        String Contrasena = "nH6?tI)#e";
        //act
        Veterinario veterinario = veterinarioRepositorio.findVeterinarioByNombreAndContrasena(Cedula,Contrasena);
        //assert
        Assertions.assertThat(veterinario).isNotNull();
    }

    @Test
    public void veterinarioRepositorio_desactivarVeterinarioPorId_listVeterinario(){
        //arrange
        Long id = 2L;
        //act
        veterinarioRepositorio.desactivarVeterinarioPorId(id);

        List<Veterinario> veterinario = veterinarioRepositorio.findByActivoTrue();
        //assert
        Assertions.assertThat(veterinario.size()).isGreaterThan(0);
        Assertions.assertThat(veterinario.size()).isEqualTo(4);
    }
    
}
