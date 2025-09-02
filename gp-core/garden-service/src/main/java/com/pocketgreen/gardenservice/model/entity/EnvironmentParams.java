package com.pocketgreen.gardenservice.model.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnvironmentParams {

    private Integer humidityMin;
    private Integer humidityMax;
    private Integer temperatureMax;
    private Integer temperatureMin;
}
