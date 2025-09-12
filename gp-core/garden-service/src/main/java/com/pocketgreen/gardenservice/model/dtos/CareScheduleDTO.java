package com.pocketgreen.gardenservice.model.dtos;

import com.pocketgreen.gardenservice.model.enums.WaterFrequency;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record CareScheduleDTO(
        @NotNull
        WaterFrequency waterFrequency,

        @PositiveOrZero
        Integer waterCounty
) {}