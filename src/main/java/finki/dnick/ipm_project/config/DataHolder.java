package finki.dnick.ipm_project.config;

import finki.dnick.ipm_project.domain.entities.Course;
import finki.dnick.ipm_project.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
@AllArgsConstructor
public class DataHolder {
    public final CourseRepository courseRepository;

    @PostConstruct
    public void init(){
        if(!courseRepository.existsByTitle("DDD"))
            courseRepository.save(new Course("DDD","1","1",1));

        if(!courseRepository.existsByTitle("Pests"))
            courseRepository.save(new Course("Pests","2","2",2));

        if(!courseRepository.existsByTitle("IPM introduction"))
            courseRepository.save(new Course("IPM introduction","3","3",2));

        if(!courseRepository.existsByTitle("Pesticides"))
            courseRepository.save(new Course("Pesticides","4","4",3));
    }
}
