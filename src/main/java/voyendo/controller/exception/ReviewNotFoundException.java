package voyendo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Review no encontrada")
public class ReviewNotFoundException extends RuntimeException {
}
