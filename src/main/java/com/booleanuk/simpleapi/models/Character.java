package com.booleanuk.simpleapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"region", "buildings", "residents"})
    private Region region;

    public Character(String firstname, String lastname, Region region) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.region = region;
    }
}
