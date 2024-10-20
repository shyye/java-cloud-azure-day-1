package com.booleanuk.simpleapi.repositories;

import com.booleanuk.simpleapi.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}
