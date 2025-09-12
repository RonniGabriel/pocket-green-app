package com.pocketgreen.gardenservice.model.dtos;

import com.pocketgreen.gardenservice.model.enums.LightExposure;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record PlantRequestDTO(
        @NotBlank @Size(max = 120)
        String name,

        @NotBlank @Size(max = 160)
        String scientificName,

        @Size(max = 2000)
        String notes,

        @Size(max = 120)
        String location,

        @NotNull
        Boolean indoor,

        @NotNull
        LightExposure lightExposure,

        @Valid
        EnvironmentParamsDTO environment,

        @Valid
        CareScheduleDTO care,

        @NotNull @PositiveOrZero
        Integer units
) {}
