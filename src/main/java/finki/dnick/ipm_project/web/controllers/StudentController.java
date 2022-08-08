package finki.dnick.ipm_project.web.controllers;

import com.lowagie.text.DocumentException;
import finki.dnick.ipm_project.domain.entities.Student;
import finki.dnick.ipm_project.service.CourseService;
import finki.dnick.ipm_project.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@AllArgsConstructor
public class StudentController {

    public final StudentService studentService;
    public final CourseService courseService;

    @GetMapping("/students/export/pdf")
    public void GenerateCertificate(
            HttpServletResponse response,
            @RequestParam String courseName) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Certificate";
        String headerValue = "attachment; filename=Certificate_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        Student student = studentService.getAuthenticatedUser();
        studentService.generateCertificate(student.getId(),courseName,response);
    }

}
