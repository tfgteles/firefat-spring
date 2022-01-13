package com.firefat.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName = "game_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "game_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    private String gameName;

    private String gameDescription;

    private boolean isActive;

    private float minWeightLoss;

    @ManyToOne
    @JoinColumn(
            name = "weight_unit_id",
            foreignKey = @ForeignKey(name = "WEIGHT_UNIT_ID_FK")
    )
    private WeightUnit weightUnit;

    private float gameFee;

    @ManyToOne
    @JoinColumn(
            name = "currency_id",
            foreignKey = @ForeignKey(name = "CURRENCY_ID_FK")
    )
    private Currency currency;

    private int vacationLength;

    private boolean lastWeightPaid;

    @ManyToMany
    private Collection<Member> members = new ArrayList<>();

    @ManyToMany
    private Collection<WeightDate> weightDates = new ArrayList<>();
}
