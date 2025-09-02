package com.pocketgreen.gardenservice.model.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record EnvironmentParamsDTO(

        @Min(0) @Max(100) Integer humidityMin,
        @Min(0) @Max(100) Integer humidityMax,
        Integer tempMinC,
        Integer tempMaxC
)
{}