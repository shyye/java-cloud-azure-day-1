package com.booleanuk.simpleapi.repositories;

import com.booleanuk.simpleapi.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
