package se.sti.stijuliomax.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.sti.stijuliomax.entity.Course;
import se.sti.stijuliomax.entity.Student;
import se.sti.stijuliomax.entity.Teacher;
import se.sti.stijuliomax.repository.CourseRepository;
import se.sti.stijuliomax.repository.StudentRepository;
import se.sti.stijuliomax.repository.TeacherRepository;

import java.util.List;

@Configuration
public class InitialDataConfig {
    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        return args -> {
            Student arne = new Student(198905083612L, "Arne", "Andersson");
            Student kalle = new Student(197003056513L, "Kalle", "Karlsson");

            Teacher moa = new Teacher(198501011010L, 250L, "Moa", "Gunnarsson");
            Teacher anna = new Teacher(197502022020L, 300L, "Anna", "Hansson");

            Course java = new Course(25L, 80L);
            java.setTeacher(moa);
            Course sql = new Course(35L, 90L);
            sql.setTeacher(anna);

            arne.getCourses().add(sql);
            kalle.getCourses().add(sql);

            teacherRepository.saveAll(List.of(moa, anna));
            courseRepository.saveAll(List.of(java, sql));
            studentRepository.saveAll(List.of(arne, kalle));
        };
    }
}
