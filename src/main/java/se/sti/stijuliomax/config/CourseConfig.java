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
            Course java = new Course(444, 25, 80);

            Course sql = new Course(555, 25, 80);

            repository.saveAll(List.of(java, sql));
        };
    }
}
