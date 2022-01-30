package se.sti.stijuliomax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.sti.stijuliomax.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
