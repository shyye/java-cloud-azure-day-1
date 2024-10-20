package com.booleanuk.simpleapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String hours;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"buildings", "residents"})
    private Region region;
}
