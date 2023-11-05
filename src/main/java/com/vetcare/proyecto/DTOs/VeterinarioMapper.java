package com.vetcare.proyecto.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vetcare.proyecto.entities.Veterinario;

@Mapper
public interface VeterinarioMapper {

    VeterinarioMapper INSTANCE  = Mappers.getMapper(VeterinarioMapper.class);
    VeterinarioDto convert(Veterinario veterinario);
    
}
