package se.sti.stijuliomax.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.sti.stijuliomax.entity.Course;
import se.sti.stijuliomax.entity.Student;
import se.sti.stijuliomax.repository.CourseRepository;
import se.sti.stijuliomax.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long personalId) {
        return studentRepository.findById(personalId);
    }

    @Transactional
    public Student addCourse(Long personalId, Long courseId) {
        Student student = studentRepository.findById(personalId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        student.getCourses().add(course);
        return student;
    }

    @Transactional
    public Student removeCourse(Long personalId, Long courseId) {
        Student student = studentRepository.findById(personalId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        student.getCourses().remove(course);
        return student;
    }

    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long personalId) {
        boolean exists = studentRepository.existsById(personalId);
        if (!exists) {
            throw new IllegalStateException("student with id " + personalId + " does not exists");
        }
        studentRepository.deleteById(personalId);
    }
}
