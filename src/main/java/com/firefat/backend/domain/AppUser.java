package com.firefat.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String preferredName;

    private Long currentGameId;

    @ManyToOne
    @JoinColumn(
            name = "gender_id",
            foreignKey = @ForeignKey(name = "GENDER_ID_FK")
    )
    private Gender gender;

    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(
            name = "country_id",
            foreignKey = @ForeignKey(name = "COUNTRY_ID_FK")
    )
    private Country country;

    private float userHeight;

    @ManyToOne
    @JoinColumn(
            name = "height_unit_id",
            foreignKey = @ForeignKey(name = "HEIGHT_UNIT_ID_FK")
    )
    private HeightUnit heightUnit;

    private String photoUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> appRoles = new ArrayList<>();

}
