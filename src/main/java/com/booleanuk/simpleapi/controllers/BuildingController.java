package com.booleanuk.simpleapi.controllers;

import com.booleanuk.simpleapi.models.Building;
import com.booleanuk.simpleapi.repositories.BuildingRepository;
import com.booleanuk.simpleapi.responses.BuildingListResponse;
import com.booleanuk.simpleapi.responses.BuildingResponse;
import com.booleanuk.simpleapi.responses.ErrorResponse;
import com.booleanuk.simpleapi.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @GetMapping("{id}")
    public ResponseEntity<Response<?>> getBById(@PathVariable int id) {
        Building building = this.buildingRepository.findById(id).orElse(null);
        if (building == null) {
            ErrorResponse error = new ErrorResponse();
            error.set("not found");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
        BuildingResponse response = new BuildingResponse();
        response.set(building);
        return ResponseEntity.ok(response);
    }
}
