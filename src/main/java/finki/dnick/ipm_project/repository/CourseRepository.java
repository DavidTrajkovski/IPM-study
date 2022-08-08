package finki.dnick.ipm_project.repository;

import finki.dnick.ipm_project.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Optional<Course> findByTitle(String title);
    Boolean existsByTitle(String title);
}
