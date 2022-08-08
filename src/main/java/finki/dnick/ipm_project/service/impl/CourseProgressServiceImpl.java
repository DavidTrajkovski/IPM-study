package finki.dnick.ipm_project.service.impl;

import finki.dnick.ipm_project.domain.entities.CourseProgress;
import finki.dnick.ipm_project.domain.entities.Student;
import finki.dnick.ipm_project.repository.CourseProgressRepository;
import finki.dnick.ipm_project.service.CourseProgressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseProgressServiceImpl implements CourseProgressService {

    private final CourseProgressRepository courseProgressRepository;

    @Override
    public void markCourseProgress(Student student, Integer courseNumber, Integer lectionNumber) {
        if(!courseProgressRepository.existsByStudentIdAndCourseNumberAndLectionNumber(student.getId(),courseNumber,lectionNumber)) {
            courseProgressRepository.save(new CourseProgress(student,courseNumber,lectionNumber));
        }
    }

    @Override
    public int getCoursePestsProgress(Student student) {
        Integer progress = courseProgressRepository.countAllByStudentIdAndCourseNumber(student.getId(),1);
        if(progress.equals(1))
            return 50;
        else if(progress.equals(2))
            return 100;
        else
            return 0;
    }

    @Override
    public int getCourseIPMProgress(Student student) {
        Integer progress = courseProgressRepository.countAllByStudentIdAndCourseNumber(student.getId(),2);
        if(progress.equals(1))
            return 50;
        else if(progress.equals(2))
            return 100;
        else
            return 0;
    }

    @Override
    public int getCoursePesticidesProgress(Student student) {
        Integer progress = courseProgressRepository.countAllByStudentIdAndCourseNumber(student.getId(),3);
        if(progress.equals(1))
            return 33;
        else if(progress.equals(2))
            return 66;
        else if(progress.equals(3))
            return 100;
        else
            return 0;
    }

    @Override
    public int getCourseDDDProgress(Student student) {
        Integer progress = courseProgressRepository.countAllByStudentIdAndCourseNumber(student.getId(),4);
        if(progress.equals(1))
            return 100;
        else
            return 0;
    }
}
