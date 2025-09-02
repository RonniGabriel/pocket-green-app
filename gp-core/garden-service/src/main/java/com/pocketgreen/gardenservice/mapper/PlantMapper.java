package com.pocketgreen.gardenservice.mapper;

import com.pocketgreen.gardenservice.model.dtos.PlantRequestDTO;
import com.pocketgreen.gardenservice.model.dtos.PlantResponseDTO;
import com.pocketgreen.gardenservice.model.entity.Plant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlantMapper {

    Plant dtoToEntity(PlantRequestDTO request);

    PlantResponseDTO entityToDto(Plant entity);

    List<PlantResponseDTO> toDtoList(List<Plant> entities);
}

