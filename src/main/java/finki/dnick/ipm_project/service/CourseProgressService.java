package finki.dnick.ipm_project.service;

import finki.dnick.ipm_project.domain.entities.Student;

public interface CourseProgressService {
    void markCourseProgress(Student student, Integer courseNumber, Integer lectionNumber);
    int getCoursePestsProgress(Student student);
    int getCourseIPMProgress(Student student);
    int getCoursePesticidesProgress(Student student);
    int getCourseDDDProgress(Student student);
}
