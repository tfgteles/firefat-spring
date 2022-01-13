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
public class Member {
    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "app_user_id",
            foreignKey = @ForeignKey(name = "APP_USER_ID_FK")
    )
    private AppUser appUser;

    private float weightGoal;

    @ManyToOne
    @JoinColumn(
            name = "vacation_start_date_id",
            foreignKey = @ForeignKey(name = "VACATION_START_DATE_ID_FK")
    )
    private WeightDate vacationStartDate;

    @ManyToOne
    @JoinColumn(
            name = "member_status_id",
            foreignKey = @ForeignKey(name = "MEMBER_STATUS_ID_FK")
    )
    private MemberStatus memberStatus;

    @ManyToMany
    private Collection<Payment> payments = new ArrayList<>();

    @ManyToMany
    private Collection<Weight> weights = new ArrayList<>();
}
