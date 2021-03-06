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
@EqualsAndHashCode
public class Derry {

    @SequenceGenerator(
            name = "derry_sequence",
           sequenceName = "derry_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "derry_sequence"
    )
    @Id
    private Long id;
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    private LocalDate dob;
    /** Do not make column on table because it is compilated/calculate , need make new getMethod with calculation*/
    @Transient
    private Integer age;

    public Derry(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Integer getAge() { return Period.between(dob, LocalDate.now()).getYears(); }
}
