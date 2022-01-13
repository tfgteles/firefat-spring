package com.firefat.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberStatus {

    @Id
    @SequenceGenerator(
            name = "member_status_sequence",
            sequenceName = "member_status_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_status_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    private String name;
}
