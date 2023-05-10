package peaksoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.springboot.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
