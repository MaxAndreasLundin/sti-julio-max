package se.sti.stijuliomax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.sti.stijuliomax.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
