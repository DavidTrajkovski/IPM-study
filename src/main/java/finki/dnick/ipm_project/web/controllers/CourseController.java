package finki.dnick.ipm_project.web.controllers;

import finki.dnick.ipm_project.domain.entities.Student;
import finki.dnick.ipm_project.service.CourseProgressService;
import finki.dnick.ipm_project.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class CourseController {

    private final CourseProgressService courseProgressService;
    private final StudentService studentService;

    @GetMapping("/courses")
    public String getStudy() {
        return "study";
    }


    //Pests Course

    @GetMapping("/courses-pests")
    public String getPests() {
        return "courses-pests";
    }

    @GetMapping("/courses-pests-l1")
    public String getPestsL1() {
        return "courses-pests-l1";
    }

    @GetMapping("/courses-pests-l2")
    public String getPestsL2() {
        Student student = studentService.getAuthenticatedUser();
        courseProgressService.markCourseProgress(student,1,1);
        return "courses-pests-l2";
    }

    @GetMapping("/courses-pests-finish")
    public String getPestsFinish() {
        Student student = studentService.getAuthenticatedUser();
        courseProgressService.markCourseProgress(student,1,2);
        return "courses-pests-finish";
    }


    //IPM Introduction Course

    @GetMapping("/courses-ipm")
    public String getIPM() {
        return "courses-ipm";
    }

    @GetMapping("/courses-ipm-l1")
    public String getIPML1() {
        return "courses-ipm-l1";
    }

    @GetMapping("/courses-ipm-l2")
    public String getIPML2() {
        Student student = studentService.getAuthenticatedUser();
        courseProgressService.markCourseProgress(student,2,1);
        return "courses-ipm-l2";
    }

    @GetMapping("/courses-ipm-finish")
    public String getIPMLFinish() {
        Student student = studentService.getAuthenticatedUser();
        courseProgressService.markCourseProgress(student,2,2);
        return "courses-ipm-finish";
    }


    // Pesticides Course

    @GetMapping("/courses-pesticides")
    public String getPesticides() {
        return "courses-pesticides";
    }

    @GetMapping("/courses-pesticides-l1")
    public String getPesticidesL1() {
        return "courses-pesticides-l1";
    }

    @GetMapping("/courses-pesticides-l2")
    public String getPesticidesL2() {
        Student student = studentService.getAuthenticatedUser();
        courseProgressService.markCourseProgress(student,3,1);
        return "courses-pesticides-l2";
    }

    @GetMapping("/courses-pesticides-l3")
    public String getPesticidesL3() {
        Student student = studentService.getAuthenticatedUser();
        courseProgressService.markCourseProgress(student,3,2);
        return "courses-pesticides-l3";
    }

    @GetMapping("/courses-pesticides-finish")
    public String getPesticidesFinish() {
        Student student = studentService.getAuthenticatedUser();
        courseProgressService.markCourseProgress(student,3,3);
        return "courses-pesticides-finish";
    }


    // DDD Course

    @GetMapping("/courses-ddd")
    public String getDDD() {
        return "courses-ddd";
    }

    @GetMapping("/courses-ddd-l1")
    public String getDDDL1() {
        return "courses-ddd-l1";
    }

    @GetMapping("/courses-ddd-finish")
    public String getDDDFinish() {
        Student student = studentService.getAuthenticatedUser();
        courseProgressService.markCourseProgress(student,4,1);
        return "courses-ddd-finish";
    }

}
