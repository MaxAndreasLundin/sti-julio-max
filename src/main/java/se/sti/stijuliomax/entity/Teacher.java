package se.sti.stijuliomax.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private int personalId;
    private int salary;
    private String name;
    private String surname;

    public Teacher(int personalId, int salary, String name, String surname) {
        this.personalId = personalId;
        this.salary = salary;
        this.name = name;
        this.surname = surname;
    }
}
