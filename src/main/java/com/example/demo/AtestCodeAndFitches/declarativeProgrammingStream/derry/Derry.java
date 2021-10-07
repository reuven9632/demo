package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(
        name = "derry",
        uniqueConstraints = {
                @UniqueConstraint(name = "derry_email_unique", columnNames = "email")
                /** if i make unique constraint on @Table i can not do unique on @Column*/
        }
)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Derry {

    @SequenceGenerator(
            name = "derry_sequence",
           sequenceName = "darry_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "derry_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    /** Do not make column on table because it is compilated/calculate , need make new getMethod with calculation*/
    @Transient
    private Integer age;

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
