package finki.dnick.ipm_project.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @SequenceGenerator(
            name="serialNumber_sequence_generator",
            sequenceName = "serialNumber_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "serialNumber_sequence_generator"
    )
    private Integer serialNumber;

    private LocalDate dateIssued;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    private Course course;

    private String certificateName;

    public Certificate(Student student, Course course, Integer serialNumber, LocalDate dateIssued, String certificateName) {
        this.serialNumber = serialNumber;
        this.dateIssued = dateIssued;
        this.student = student;
        this.course = course;
        this.certificateName = certificateName;
    }
}
