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
public class Course {
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
    private int courseId;
    private int points;
    private int hours;

    public Course(int courseId, int points, int hours) {
        this.courseId = courseId;
        this.points = points;
        this.hours = hours;
    }
}

