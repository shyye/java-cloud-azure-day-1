package com.booleanuk.simpleapi.controllers;

import com.booleanuk.simpleapi.models.Character;
import com.booleanuk.simpleapi.repositories.CharacterRepository;
import com.booleanuk.simpleapi.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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

    @GetMapping("{id}")
    public ResponseEntity<Response<?>> getBById(@PathVariable int id) {
        Character character = this.characterRepository.findById(id).orElse(null);
        if (character == null) {
            ErrorResponse error = new ErrorResponse();
            error.set("not found");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
        CharacterResponse response = new CharacterResponse();
        response.set(character);
        return ResponseEntity.ok(response);
    }
}
