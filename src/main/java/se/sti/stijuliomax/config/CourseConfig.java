package se.sti.stijuliomax.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.sti.stijuliomax.entity.Course;
import se.sti.stijuliomax.repository.CourseRepository;

import java.util.List;

@Configuration
public class CourseConfig {
    @Bean
    CommandLineRunner commandLineRunnerCourse(CourseRepository repository) {
        return args -> {
            Course java = new Course(444L, 25L, 80L);

            Course sql = new Course(555L, 25L, 80L);

            repository.saveAll(List.of(java, sql));
        };
    }
}
