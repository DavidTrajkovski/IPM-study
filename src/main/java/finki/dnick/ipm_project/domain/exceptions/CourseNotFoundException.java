package finki.dnick.ipm_project.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "course not found")
public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String name) {
        super(String.format("Course with ID: %s not found.", name));
    }

    public CourseNotFoundException(Integer courseId) {
        super(String.format("Course with ID: %d not found.", courseId));
    }
}
