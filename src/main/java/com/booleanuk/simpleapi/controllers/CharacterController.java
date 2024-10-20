package com.booleanuk.simpleapi.controllers;

import com.booleanuk.simpleapi.repositories.CharacterRepository;
import com.booleanuk.simpleapi.repositories.RegionRepository;
import com.booleanuk.simpleapi.responses.CharacterListResponse;
import com.booleanuk.simpleapi.responses.RegionListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping
    public ResponseEntity<CharacterListResponse> getAll() {
        CharacterListResponse response = new CharacterListResponse();
        response.set(this.characterRepository.findAll());
        return ResponseEntity.ok(response);
    }
}
