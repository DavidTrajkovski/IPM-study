package finki.dnick.ipm_project.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    private String title;

    private String time;

    private String difficulty;

    private int numberOfLectures;

    public Course(String title, String time, String difficulty, int numberOfLectures) {
        this.title = title;
        this.time = time;
        this.difficulty = difficulty;
        this.numberOfLectures = numberOfLectures;
    }
}
