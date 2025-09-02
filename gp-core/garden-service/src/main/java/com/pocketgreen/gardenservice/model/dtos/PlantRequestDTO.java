package com.pocketgreen.gardenservice.model.dtos;

import com.pocketgreen.gardenservice.model.enums.LightExposure;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record PlantRequestDTO(
        @NotBlank String name,
        @NotBlank String scientificName,
        @Size(max = 2000) String notes,
        String location,
        @NotNull Boolean indoor,
        @NotNull LightExposure lightExposure,
        @Valid EnvironmentParamsDTO environment,
        @Valid CareScheduleDTO care
) {}
