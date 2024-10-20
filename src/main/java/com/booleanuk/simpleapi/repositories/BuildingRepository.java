package com.booleanuk.simpleapi.repositories;

import com.booleanuk.simpleapi.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
