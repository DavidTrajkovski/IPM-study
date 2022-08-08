package finki.dnick.ipm_project.service.impl;

import finki.dnick.ipm_project.domain.entities.Course;
import finki.dnick.ipm_project.domain.exceptions.CourseNotFoundException;
import finki.dnick.ipm_project.repository.CourseRepository;
import finki.dnick.ipm_project.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course findByCourseName(String courseName) {
        return this.courseRepository.findByTitle(courseName).orElseThrow(() -> new CourseNotFoundException(courseName));
    }
}
