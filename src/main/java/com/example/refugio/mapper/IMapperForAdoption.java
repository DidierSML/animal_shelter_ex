package com.example.refugio.mapper;
import com.example.refugio.dto.AnimalForAdoptionDTO;
import com.example.refugio.model.AnimalForAdoption;
import jakarta.validation.Valid;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface IMapperForAdoption {

    IMapperForAdoption INSTANCE = Mappers.getMapper(IMapperForAdoption.class);

    AnimalForAdoption dtoModel (@Valid AnimalForAdoptionDTO forAdoptionDTO);

    @InheritInverseConfiguration
    AnimalForAdoptionDTO modelToDto (@Valid AnimalForAdoption forAdoption);

    List<AnimalForAdoptionDTO> modelsToDtos (@Valid List<AnimalForAdoption> forAdoption);

}
