package finki.dnick.ipm_project.service.impl;

import finki.dnick.ipm_project.domain.entities.Certificate;
import finki.dnick.ipm_project.domain.entities.Course;
import finki.dnick.ipm_project.domain.entities.Student;
import finki.dnick.ipm_project.domain.enums.Roles;
import finki.dnick.ipm_project.domain.exceptions.StudentNotFoundException;
import finki.dnick.ipm_project.repository.CertificateRepository;
import finki.dnick.ipm_project.repository.StudentRepository;
import finki.dnick.ipm_project.service.CourseService;
import finki.dnick.ipm_project.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CertificateRepository certificateRepository;
    private final CourseService courseService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Student findByStudentId(Integer id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public Boolean findByStudentIdAndCourseTitle(Integer studentId, String courseTitle) {
        return this.certificateRepository.existsByStudentIdAndCourse_Title(studentId,courseTitle);
    }

    @Override
    public void generateCertificate(Integer studentId, String courseName, HttpServletResponse response) throws DocumentException, IOException{
        Random rand = new Random();
        Integer serialNumber = 10000 + rand.nextInt((99999 - 10000) + 1);
        Student student = findByStudentId(studentId);
        Course course = courseService.findByCourseName(courseName);
        Certificate certificate = new Certificate(student,course,serialNumber,LocalDate.now(), courseName);

        if(!findByStudentIdAndCourseTitle(studentId,courseName)) {
            certificateRepository.saveAndFlush(certificate);
            student.getCertificatesOwned().add(certificate);
            studentRepository.saveAndFlush(student);
        }

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Paragraph newline = new Paragraph("""
                \s
                
                """);

        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font1.setSize(30);
        Paragraph p1 = new Paragraph("""
                CERTIFICATE OF COMPLETION\s

                """, font1);
        p1.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p1);
        document.add(newline);

        Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font2.setSize(20);
        Paragraph p2 = new Paragraph("This certificate is presented to:", font2);
        p2.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p2);

        Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font3.setSize(28);
        Paragraph p3 = new Paragraph(student.getFirstName() + " " + student.getLastName() + "\n", font3);
        p3.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p3);
        document.add(newline);

        Font font4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font4.setSize(18);
        Paragraph p4 = new Paragraph("For the successful completion of the course: " + "\n" +  /*course.getTitle()*/ courseName +  "\n" + " and " +
                "successfully passing the test", font4);
        p4.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p4);

        document.add(newline);
        document.add(newline);

        Font font5 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font5.setSize(16);
        Paragraph p5 = new Paragraph("Date: " + certificate.getDateIssued(), font5);
        Paragraph p6 = new Paragraph("Certificate serial number: " + certificate.getSerialNumber(), font5);
        p5.setAlignment(Paragraph.ALIGN_LEFT);
        p6.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p5);
        document.add(p6);
        document.add(newline);
        Paragraph p7 = new Paragraph("IPM study page", font5);
        p7.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(p7);
        document.add(newline);

        document.close();
    }

    @Override
    public void register(String name, String surname, String email, String password, String repeatPassword) {
        if (email==null || email.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidParameterException();

        if (!password.equals(repeatPassword))
            throw new BadCredentialsException("Invalid Credentials - password not equal");

        if(this.studentRepository.findByEmail(email).isPresent())
            throw new BadCredentialsException("Invalid Credentials - already exists");

        Student student = new Student(name, surname, email, passwordEncoder.encode(password));
        student.setRole(Roles.ROLE_USER);

        this.studentRepository.save(student);
    }

    @Override
    public Student getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (Student) auth.getPrincipal();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.studentRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Transactional
    @Override
    public void update(Student student, String firstName, String lastName, String email, String password, String confirmPassword) {
        if (student == null)
            return;

        if(firstName != null && !firstName.equals("")) {
            student.setFirstName(firstName);
        }

        if(lastName != null && !lastName.equals("")) {
            student.setLastName(lastName);
        }

        if(email != null && !email.equals("")) {
            student.setEmail(email);
        }

        if(password != null && !password.equals("") && confirmPassword != null && !confirmPassword.equals("") && password.equals(confirmPassword))
            student.setPassword(passwordEncoder.encode(password));

        studentRepository.save(student);
    }

    @Override
    public List<String> getCertificates(Student student) {
        List<String> certificates = new ArrayList<>();
        certificateRepository.findAll().stream()
                .filter(c -> c.getStudent().getId().equals(student.getId()))
                .forEach(c -> certificates.add(c.getCertificateName()));
        return certificates;
    }
}
