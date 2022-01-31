package se.sti.stijuliomax.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Student {
    @Id
    @Column(unique=true)
    private Long id;
    private String name;
    private String surname;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Student_Course",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> courses = new HashSet<>();

    public Student(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public void setCourses(Course course) {
        courses.add(course);
    }
}
