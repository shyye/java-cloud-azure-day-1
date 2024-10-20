package com.booleanuk.simpleapi.controllers;


import com.booleanuk.simpleapi.models.Region;
import com.booleanuk.simpleapi.repositories.RegionRepository;

import com.booleanuk.simpleapi.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("regions")
public class RegionController {
    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    public ResponseEntity<RegionListResponse> getAll() {
        RegionListResponse response = new RegionListResponse();
        response.set(this.regionRepository.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<Response<?>> getBById(@PathVariable int id) {
        Region region = this.regionRepository.findById(id).orElse(null);
        if (region == null) {
            ErrorResponse error = new ErrorResponse();
            error.set("not found");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
        RegionResponse response = new RegionResponse();
        response.set(region);
        return ResponseEntity.ok(response);
    }
}
