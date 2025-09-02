    package com.pocketgreen.gardenservice.controller;

import com.pocketgreen.gardenservice.model.dtos.PlantRequestDTO;
import com.pocketgreen.gardenservice.model.dtos.PlantResponseDTO;
import com.pocketgreen.gardenservice.service.PlantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/plants")
@RestController
public class PlantController {

    private PlantService plantService;

    @PostMapping("")
    public ResponseEntity<PlantResponseDTO> createPlant(PlantRequestDTO requestDTO){
      return ResponseEntity.ok(plantService.create(requestDTO));
    }

    @GetMapping("")
    public ResponseEntity<Optional<PlantResponseDTO>> getPlantById (UUID plantId){
        return  ResponseEntity.ok(plantService.getPlantById(plantId));
    }

    @GetMapping("")
    public ResponseEntity<List<PlantResponseDTO>> getAllPlants (){
        return  ResponseEntity.ok(plantService.getAll());
    }

    @PutMapping("")
    public ResponseEntity<PlantResponseDTO> updatePlant (UUID plantId, PlantRequestDTO requestDTO){
        return ResponseEntity.ok(plantService.update(plantId,requestDTO));
    }

    @DeleteMapping("")
    public void delete(UUID plantId){
         plantService.delete(plantId);
    }

}