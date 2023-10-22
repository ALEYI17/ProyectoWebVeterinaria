package com.vetcare.proyecto.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vetcare.proyecto.entities.Admin;
import com.vetcare.proyecto.repository.AdminRepositorio;

@DataJpaTest
@RunWith(SpringRunner.class)
public class adminRepositoryTest {
    @Autowired
    AdminRepositorio adminRepositorio;

    @BeforeEach
    public void setUp(){
        adminRepositorio.save(new Admin("123", "123"));
    }

    @Test
    public void adminRepositorio_login_admin(){
        //arrange
        String usuario = "123";
        String Contrasena="123";
        //act
        Admin admin=adminRepositorio.findAdmin(usuario, Contrasena);
        //assert
        Assertions.assertThat(admin).isNotNull();
    }

}
