package com.pocketgreen.gardenservice.model.entity;

import com.pocketgreen.gardenservice.model.enums.LightExposure;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "plant")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Size(max = 120)
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @NotBlank
    @Size(max = 160)
    @Column(name = "scientific_name", nullable = false, length = 160)
    private String scientificName;

    @Size(max = 2000)
    @Column(name = "notes", length = 2000)
    private String notes;

    @Size(max = 120)
    @Column(name = "location", length = 120)
    private String location;

    @NotNull
    @Column(name = "indoor", nullable = false)
    private Boolean indoor;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "light_exposure", nullable = false, length = 20)
    private LightExposure lightExposure;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "humidityMin", column = @Column(name = "humidity_min")),
            @AttributeOverride(name = "humidityMax", column = @Column(name = "humidity_max")),
            @AttributeOverride(name = "temperatureMax", column = @Column(name = "temperature_max")),
            @AttributeOverride(name = "temperatureMin", column = @Column(name = "temperature_min"))
    })
    private EnvironmentParams environmentParams;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "waterFrequency", column = @Column(name = "water_frequency")),
            @AttributeOverride(name = "waterCounty", column = @Column(name = "water_county"))
    })
    private CareSchedule careSchedule;

    @NotNull
    @PositiveOrZero
    @Builder.Default
    @Column(name = "units", nullable = false)
    private Integer units = 1;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;
}
