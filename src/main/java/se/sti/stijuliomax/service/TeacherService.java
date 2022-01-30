package se.sti.stijuliomax.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sti.stijuliomax.entity.Teacher;
import se.sti.stijuliomax.repository.TeacherRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long teacherId) {
        boolean exists = teacherRepository.existsById(teacherId);
        if (!exists) {
            throw new IllegalStateException("student with id " + teacherId + " does not exists");
        }
        teacherRepository.deleteById(teacherId);
    }
}
