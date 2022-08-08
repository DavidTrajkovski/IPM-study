package finki.dnick.ipm_project.web.controllers;

import finki.dnick.ipm_project.domain.entities.Student;
import finki.dnick.ipm_project.repository.StudentRepository;
import finki.dnick.ipm_project.service.CourseProgressService;
import finki.dnick.ipm_project.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.InvalidParameterException;

@Controller
@AllArgsConstructor
public class HomeController {

    private final StudentService studentService;
    private final CourseProgressService courseProgressService;
    private final StudentRepository studentRepository;

    @GetMapping(value = {"/","/welcome"})
    public String getWelcome(){
        return "welcome";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/professional-help")
    public String getProfessionalHelp() {
        return "professional-help";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String confirmPassword) {
        try {
            this.studentService.register(name, surname, email, password, confirmPassword);
            return "redirect:/";
        } catch (InvalidParameterException | BadCredentialsException e) {
            return "redirect:/register?error=" + e.getMessage();
        }
    }

    @GetMapping("/my-profile")
    public String getMyProfilePage(Model model){
        Student student = studentService.getAuthenticatedUser();
        model.addAttribute("student",student);
        model.addAttribute("certificates",studentService.getCertificates(student));
        model.addAttribute("c1_progress",courseProgressService.getCoursePestsProgress(student));
        model.addAttribute("c2_progress",courseProgressService.getCourseIPMProgress(student));
        model.addAttribute("c3_progress",courseProgressService.getCoursePesticidesProgress(student));
        model.addAttribute("c4_progress",courseProgressService.getCourseDDDProgress(student));
        return "my-profile";
    }

    @PostMapping("/my-profile")
    public String editProfile(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String confirmPassword) {
        Student student = studentService.getAuthenticatedUser();
        studentService.update(student,firstName,lastName,email,password,confirmPassword);
        return "redirect:/my-profile";
    }
}
