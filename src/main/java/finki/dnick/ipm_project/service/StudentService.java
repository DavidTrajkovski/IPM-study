package finki.dnick.ipm_project.service;

import finki.dnick.ipm_project.domain.entities.Student;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface StudentService extends UserDetailsService {
    Student findByStudentId(Integer id);
    Boolean findByStudentIdAndCourseTitle(Integer id, String courseTitle);
    void generateCertificate(Integer studentId, String courseName, HttpServletResponse response) throws IOException;
    void register(String name, String surname, String email, String password, String repeatPassword);
    Student getAuthenticatedUser();
    void update(Student student, String firstName, String lastName, String email, String password, String confirmPassword);
    List<String> getCertificates(Student student);
}
