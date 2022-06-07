package voyendo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Empresa no encontrada")
public class CompanyNotFoundException extends RuntimeException {
}
