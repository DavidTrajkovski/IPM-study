package finki.dnick.ipm_project.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "student not found")
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Integer id) {
        super(String.format("Student with ID: %d not found.", id));
    }

}
