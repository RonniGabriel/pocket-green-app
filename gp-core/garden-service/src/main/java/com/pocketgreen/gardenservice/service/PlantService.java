package com.pocketgreen.gardenservice.service;

import com.pocketgreen.gardenservice.model.dtos.PlantRequestDTO;
import com.pocketgreen.gardenservice.model.dtos.PlantResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface with all operations relate with @Entity Plant
 **/

public interface PlantService {

    PlantResponseDTO create (PlantRequestDTO plantRequestDTO);

    Optional<PlantResponseDTO> getPlantById(UUID plantId);

    List<PlantResponseDTO> getAll();

    PlantResponseDTO update (UUID plantId, PlantRequestDTO plantRequestDTO);

    void delete (UUID plantId);


}
