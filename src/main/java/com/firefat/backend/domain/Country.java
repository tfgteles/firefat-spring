package com.firefat.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @SequenceGenerator(
            name = "country_sequence",
            sequenceName = "country_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    private String name;

    private String abbreviation;
}
