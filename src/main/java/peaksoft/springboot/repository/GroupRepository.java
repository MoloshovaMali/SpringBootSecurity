package peaksoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springboot.entity.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
}
