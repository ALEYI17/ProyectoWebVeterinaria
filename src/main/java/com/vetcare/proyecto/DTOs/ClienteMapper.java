package com.vetcare.proyecto.DTOs;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Veterinario;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE  = Mappers.getMapper(ClienteMapper.class);
    ClienteDto convert(Cliente cliente);
    List<ClienteDto> convert(List<Cliente> clientes);
    
}
