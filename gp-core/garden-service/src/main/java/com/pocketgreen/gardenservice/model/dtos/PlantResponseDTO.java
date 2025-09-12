package com.pocketgreen.gardenservice.model.dtos;

import com.pocketgreen.gardenservice.model.enums.LightExposure;
import java.time.LocalDate;
import java.util.UUID;

public record PlantResponseDTO(
        UUID id,
        String name,
        String scientificName,
        String notes,
        String location,
        Boolean indoor,
        LightExposure lightExposure,
        EnvironmentParamsDTO environment,
        CareScheduleDTO care,
        Integer units,
        LocalDate createdAt,
        LocalDate updatedAt
) {}