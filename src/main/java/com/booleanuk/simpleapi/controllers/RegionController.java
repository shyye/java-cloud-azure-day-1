package com.booleanuk.simpleapi.controllers;


import com.booleanuk.simpleapi.repositories.RegionRepository;

import com.booleanuk.simpleapi.responses.RegionListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
