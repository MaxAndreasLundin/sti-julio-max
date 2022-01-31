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

    public Optional<Student> findById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Transactional
    public Student addCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        student.getCourses().add(course);
        return student;
    }

    @Transactional
    public Student removeCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        student.getCourses().remove(course);
        return student;
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
