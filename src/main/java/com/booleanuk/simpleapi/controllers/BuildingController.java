package com.booleanuk.simpleapi.controllers;

import com.booleanuk.simpleapi.models.Building;
import com.booleanuk.simpleapi.repositories.BuildingRepository;
import com.booleanuk.simpleapi.responses.BuildingListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("buildings")
public class BuildingController {

    @Autowired
    private BuildingRepository buildingRepository;

    @GetMapping
    public ResponseEntity<BuildingListResponse> getAll() {
        BuildingListResponse response = new BuildingListResponse();
        response.set(this.buildingRepository.findAll());
        return ResponseEntity.ok(response);
    }
}
