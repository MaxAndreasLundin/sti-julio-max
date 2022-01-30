package se.sti.stijuliomax.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sti.stijuliomax.entity.Student;
import se.sti.stijuliomax.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long studentId) {
        return studentRepository.findById(studentId);
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
