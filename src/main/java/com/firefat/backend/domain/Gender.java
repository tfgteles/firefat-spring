package com.firefat.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gender {
    @Id
    @SequenceGenerator(
            name = "gender_sequence",
            sequenceName = "gender_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gender_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    private String name;

    private String abbreviation;
}
