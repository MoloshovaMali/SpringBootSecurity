package peaksoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springboot.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
