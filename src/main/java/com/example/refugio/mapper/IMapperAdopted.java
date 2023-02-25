package com.example.refugio.mapper;
import com.example.refugio.dto.AdoptedAnimalDTO;
import com.example.refugio.model.AdoptedAnimal;
import jakarta.validation.Valid;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface IMapperAdopted {

    IMapperAdopted INSTANCE = Mappers.getMapper(IMapperAdopted.class);

    AdoptedAnimal dtoToModel (@Valid AdoptedAnimalDTO adoptedDto);

    @InheritInverseConfiguration
    AdoptedAnimalDTO modelToDto (@Valid AdoptedAnimal adopted);

    List<AdoptedAnimalDTO> modelsToDtos (@Valid List<AdoptedAnimal> animalsAdopted);


}
