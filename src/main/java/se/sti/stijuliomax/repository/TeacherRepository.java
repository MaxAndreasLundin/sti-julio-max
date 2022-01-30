package se.sti.stijuliomax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.sti.stijuliomax.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
