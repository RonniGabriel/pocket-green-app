package com.pocketgreen.gardenservice.model.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record EnvironmentParamsDTO(
        @Min(0) @Max(100)
        Integer humidityMin,

        @Min(0) @Max(100)
        Integer humidityMax,

        @Min(-50) @Max(70)
        Integer temperatureMin,

        @Min(-50) @Max(70)
        Integer temperatureMax
) {}