package se.sti.stijuliomax.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    private Long personalId;
    private Long salary;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;

    public Teacher(Long personalId, Long salary, String name, String surname) {
        this.personalId = personalId;
        this.salary = salary;
        this.name = name;
        this.surname = surname;
    }
}
