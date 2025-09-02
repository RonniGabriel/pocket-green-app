package com.pocketgreen.gardenservice.model.entity;

import com.pocketgreen.gardenservice.model.enums.LightExposure;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String scientificName;

    @Column(length = 2000)
    private String notes;

    private String location;

    @Column(nullable = false)
    private Boolean indoor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LightExposure lightExposure;

    @Embedded
    private EnvironmentParams environmentParams;

    @Embedded
    private CareSchedule careSchedule;

    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private LocalDate updatedAt;
}
