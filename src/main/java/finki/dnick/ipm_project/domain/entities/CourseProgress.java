package finki.dnick.ipm_project.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CourseProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Student student;

    private int courseNumber;

    private int lectionNumber;

    public CourseProgress(Student student, int courseNumber, int lectionNumber) {
        this.student = student;
        this.courseNumber = courseNumber;
        this.lectionNumber = lectionNumber;
    }
}
