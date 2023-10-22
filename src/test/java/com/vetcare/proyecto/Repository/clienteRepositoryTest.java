package com.vetcare.proyecto.Repository;

import java.util.List;
import java.util.Optional;



import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Mascota;
import com.vetcare.proyecto.repository.ClienteRepositorio;
import com.vetcare.proyecto.repository.MascotaRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class clienteRepositoryTest {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private MascotaRepository mascotaRepository;

    @BeforeEach
    public void setUp(){
        clienteRepositorio.save(new Cliente("5602222623501237","Crin Dottridge","cdottridge0@bravesites.com","184-683-8032"));
        clienteRepositorio.save(new Cliente("5610426064728825","Meghan Vain","mvain1@indiegogo.com","253-723-4589"));
        clienteRepositorio.save(new Cliente("5602248031401652","Darci Condie","dcondie2@blogtalkradio.com","755-993-2472"));
        clienteRepositorio.save(new Cliente("5610882771911973","Bernard Sackes","bsackes3@ca.gov","876-141-1589"));
        clienteRepositorio.save(new Cliente("374288553824805","Cully Matas","cmatas4@cdc.gov","764-541-3379"));
        clienteRepositorio.save(new Cliente("374288603248310","Corinne Nerne","cnerne5@time.com","541-955-9935"));
        clienteRepositorio.save(new Cliente("5610380149596485","Morgan Bernolet","mbernolet6@illinois.edu","841-465-7544"));
        clienteRepositorio.save(new Cliente("372301484707619","Yolane Thistleton","ythistleton7@ustream.tv","432-406-7458"));
        clienteRepositorio.save(new Cliente("372491765111308","Minerva Ashurst","mashurst8@list-manage.com","424-131-7675"));
        clienteRepositorio.save(new Cliente("375368923381238","Kerrin Pioch","kpioch9@hibu.com","367-259-8444")); 

        mascotaRepository.save(new Mascota("Quinta","Siamese",14,5.0,"Cistitis","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Lolly","Persian",18,4.9,"Perionitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Ranice","Lykoi",10,4.3,"Virus de la leucemia felina","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Mattheus","Siamese",9,4.4,"Virus de la leucemia felina","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Cly","Maine Coon",15,4.4,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Olag","Siamese",6,5.8,"Virus de la inmunodeficiencia felina","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Dix","Persian",15,5.7,"Otitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Gilberto","ceilán",2,4.5,"cojo","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Derek","Lykoi",17,3.2,"Conjuntivitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Cassandra","Lykoi",19,4.0,"cojo","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
       

        List<Cliente>  clientes = clienteRepositorio.findAll();
        List <Mascota> mascotas = mascotaRepository.findAll();
        Integer j=0;
        for(int i = 0 ;i<mascotas.size();i ++){

            mascotas.get(i).setCliente(clientes.get(j));
            
            j++;

        }
    }


    // test de guardar cliente
    @Test
    public void clienteRepositorio_save_Cliente(){
       
        //arange
        Cliente cliente = new Cliente("123", "Andres", "Andres@gmail.com", "34214657685");

        //act
        Cliente cliente2 = clienteRepositorio.save(cliente);

        // arrange

        Assertions.assertThat(cliente2).isNotNull();
    }

    // test de traer todos los clientes
    @Test
    public void clienteRepositorio_findAll_NotEmptyList(){
        //arrange
        Cliente cliente = new Cliente("123", "Andres", "Andres@gmail.com", "34214657685");
        Cliente cliente2 = new Cliente("345", "Alejandro", "Alejandro@gmail.com", "3456654");

        //act
        clienteRepositorio.save(cliente);
        clienteRepositorio.save(cliente2);
        List<Cliente> clientes = clienteRepositorio.findAll();

        //assert
        Assertions.assertThat(clientes).isNotNull();
        Assertions.assertThat(clientes.size()).isEqualTo(12); 
        Assertions.assertThat(clientes.size()).isGreaterThan(0);  
    }

    @Test
    public void clienteRepositorio_findById_FindWrongIndex(){
        //arrange
        Long index = -1L;

        //act
        Optional<Cliente> cliente = clienteRepositorio.findById(index);

        //assert
        Assertions.assertThat(cliente).isEmpty();

    }

    @Test
    public void clienteRepositorio_deletById_EmptCliente(){

        //Arrange
        Long index = 2L;
        //Act
        clienteRepositorio.deleteById(index);
        //assert
        Assertions.assertThat(clienteRepositorio.findById(index)).isEmpty();
    }

    @Test
    public void clienteRepositorio_findByCedula_isNotEmpty(){
        //arrange
        String cedulaPrueba = "5602222623501237";
        //act
        Cliente cliente=clienteRepositorio.findByCedula(cedulaPrueba);
        //assert

        Assertions.assertThat(cliente).isNotNull();
    }
    
    @Test
    public void clienteRepositorio_findByCedula_FindWrongIndex(){
        //arrange
        String cedulaPrueba = "123";
        //act
        Cliente cliente = clienteRepositorio.findByCedula(cedulaPrueba);
        //assert

        Assertions.assertThat(cliente).isNull();
    }

    @Test 
    public void clienteRepositorio_updateById_Cliente(){
        //arrange
        String id = "5602222623501237";
        //act
        Cliente cliente = clienteRepositorio.findByCedula(id);
        cliente.setNombre("quintaaaaaa");
        Cliente cliente2 = clienteRepositorio.save(cliente);
        //assert
        Assertions.assertThat(cliente).isNotNull();
        Assertions.assertThat(cliente2).isNotNull();
        Assertions.assertThat(cliente2.getNombre()).isEqualTo("quintaaaaaa");
    }
}
