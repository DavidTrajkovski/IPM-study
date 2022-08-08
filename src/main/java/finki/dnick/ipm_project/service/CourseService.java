package finki.dnick.ipm_project.service;

import finki.dnick.ipm_project.domain.entities.Course;

public interface CourseService {
    Course findByCourseName(String courseName);
}
