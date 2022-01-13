package com.firefat.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeightUnit {
    @Id
    @SequenceGenerator(
            name = "height_unit_sequence",
            sequenceName = "height_unit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "height_unit_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    private String name;

    private String abbreviation;
}
