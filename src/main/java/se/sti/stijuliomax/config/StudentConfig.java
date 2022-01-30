package se.sti.stijuliomax.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.sti.stijuliomax.entity.Student;
import se.sti.stijuliomax.repository.StudentRepository;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student arne = new Student (1L, 123, "Arne", "Andersson");

            Student kalle = new Student(2L, 1234,"Kalle", "Karlsson");

            repository.saveAll(List.of(arne, kalle));
        };
    }
}
