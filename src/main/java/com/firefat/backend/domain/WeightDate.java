package com.firefat.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightDate {
    @Id
    @SequenceGenerator(
            name = "weight_date_sequence",
            sequenceName = "weight_date_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "weight_date_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    private LocalDate scheduledDate;
}
