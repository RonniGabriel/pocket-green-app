package com.pocketgreen.gardenservice.repository;
import com.pocketgreen.gardenservice.model.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlantRepository extends JpaRepository<Plant, UUID> {

}
