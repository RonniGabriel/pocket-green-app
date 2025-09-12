package com.pocketgreen.gardenservice.controller;

import com.pocketgreen.gardenservice.model.dtos.PlantRequestDTO;
import com.pocketgreen.gardenservice.model.dtos.PlantResponseDTO;
import com.pocketgreen.gardenservice.service.PlantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Tag(name = "Garden Service 🪴🌱", description = "Plant Apì")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/plants", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlantController {

    private final PlantService plantService;

    @Operation(summary = "Create a plant")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = PlantResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantResponseDTO> createPlant(@Valid @RequestBody PlantRequestDTO requestDTO) {
        PlantResponseDTO created = plantService.create(requestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(created.id()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @Operation(summary = "Get a plant by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = PlantResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PlantResponseDTO> getPlantById(
            @Parameter(description = "Plant identifier") @PathVariable("id") UUID plantId) {
        Optional<PlantResponseDTO> dto = plantService.getPlantById(plantId);
        return ResponseEntity.of(dto);
    }

    @Operation(summary = "List all plants")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping
    public ResponseEntity<List<PlantResponseDTO>> getAllPlants() {
        return ResponseEntity.ok(plantService.getAll());
    }

    @Operation(summary = "Update a plant by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = PlantResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantResponseDTO> updatePlant(
            @Parameter(description = "Plant identifier") @PathVariable("id") UUID plantId,
            @Valid @RequestBody PlantRequestDTO requestDTO) {
        return ResponseEntity.ok(plantService.update(plantId, requestDTO));
    }

    @Operation(summary = "Delete a plant by id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Plant identifier") @PathVariable("id") UUID plantId) {
        plantService.delete(plantId);
        return ResponseEntity.noContent().build();
    }
}
