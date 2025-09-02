package com.pocketgreen.gardenservice.model.dtos;

import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public record CareScheduleDTO(
        @Positive
        Integer waterEveryDays,

        @Positive
        Integer fertilizeEveryDays,

        LocalDate lastWateredAt,

        LocalDate lastFertilizedAt,

        LocalDate lastPrunedAt,

        LocalDate lastRepottedAt
) {}
