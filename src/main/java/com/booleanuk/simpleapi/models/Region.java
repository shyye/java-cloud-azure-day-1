package com.booleanuk.simpleapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "region")
    @JsonIgnoreProperties({"region"})
    private List<Building> buildings = new ArrayList<>();

    @OneToMany(mappedBy = "region")
    @JsonIgnoreProperties({"region"})
    private List<Character> residents = new ArrayList<>();

    public Region(String name) {
        this.name = name;
    }

    public Region(int id) {
        this.id = id;
    }
}
