package com.firefat.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weight {
    @Id
    @SequenceGenerator(
            name = "weight_sequence",
            sequenceName = "weight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "weight_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    @ManyToOne
//    @JoinColumn(name = "weight_date_id")
    private WeightDate weightDate;

    private float weightMeasure;

    private String scaleUrl;
}
