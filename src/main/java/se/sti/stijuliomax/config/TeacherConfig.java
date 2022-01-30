package se.sti.stijuliomax.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.sti.stijuliomax.entity.Teacher;
import se.sti.stijuliomax.repository.TeacherRepository;

import java.util.List;

@Configuration
public class TeacherConfig {
    @Bean
    CommandLineRunner commandLineRunnerTeacher(TeacherRepository repository) {
        return args -> {
            Teacher moa = new Teacher(1234, 250, "Moa", "Gunnarsson");

            Teacher anna = new Teacher(1234, 250, "Anna", "Hansson");

            repository.saveAll(List.of(moa, anna));
        };
    }
}
