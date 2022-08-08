package finki.dnick.ipm_project.repository;

import finki.dnick.ipm_project.domain.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Integer> {
    Boolean existsByStudentIdAndCourse_Title(Integer studentId, String courseTitle);
}
