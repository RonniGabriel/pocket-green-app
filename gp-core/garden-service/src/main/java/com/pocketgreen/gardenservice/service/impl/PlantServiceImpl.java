package com.pocketgreen.gardenservice.service.impl;

import com.pocketgreen.gardenservice.mapper.PlantMapper;
import com.pocketgreen.gardenservice.model.dtos.PlantRequestDTO;
import com.pocketgreen.gardenservice.model.dtos.PlantResponseDTO;
import com.pocketgreen.gardenservice.model.entity.Plant;
import com.pocketgreen.gardenservice.repository.PlantRepository;
import com.pocketgreen.gardenservice.service.PlantService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 * Implementation of interface PlantService
 **/
@Service
@Transactional
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantRepository repository;

    @Autowired
    private PlantMapper mapper;

    @Override
    public PlantResponseDTO create(PlantRequestDTO plantRequestDTO) {
        return  mapper.entityToDto(repository.save(mapper.dtoToEntity(plantRequestDTO)));

    }

    @Override
    public Optional<PlantResponseDTO> getPlantById(UUID plantId) {
        return repository.findById(plantId).map(mapper::entityToDto);
    }

    @Override
    public List<PlantResponseDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public PlantResponseDTO update(UUID plantId, PlantRequestDTO plantRequestDTO) {

        Optional<Plant> plantExists = repository.findById(plantId);
        Plant plantToUpdate = mapper.dtoToEntity(plantRequestDTO);

        plantExists.ifPresent(plant -> plantToUpdate.setId(plant.getId()));
        return mapper.entityToDto(plantToUpdate);
   }

    @Override
    public void delete(UUID plantId) {
        if (!repository.existsById(plantId)) {
            throw new IllegalArgumentException("Plant not found: " + plantId);
        }
        repository.deleteById(plantId);
    }
}
