package finki.dnick.ipm_project.repository;

import finki.dnick.ipm_project.domain.entities.CourseProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseProgressRepository extends JpaRepository<CourseProgress, Integer> {

    Boolean existsByStudentIdAndCourseNumberAndLectionNumber(Integer studentId, Integer courseNumber, Integer lectionNumber);
    Integer countAllByStudentIdAndCourseNumber(Integer studentId, Integer courseNumber);
}
