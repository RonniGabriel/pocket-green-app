package com.pocketgreen.gardenservice.model.entity;

import com.pocketgreen.gardenservice.model.enums.WaterFrequency;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CareSchedule {

    @Enumerated(EnumType.STRING)
    private WaterFrequency waterFrequency;
    private Integer waterCounty;

}
