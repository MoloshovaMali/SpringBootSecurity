package peaksoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springboot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query(" select s from Student s join Group g ON s.group.id = g.id join g.courses c join Company com ON c.company.id = com.id where com.id=:id")
//    List<Student> getStudentByCompany(@Param("id") Long companyId);
//
//}
}