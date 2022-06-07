package voyendo.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason="Usuario no autorizado")
public class UsuarioNoAdministradorException extends RuntimeException {
}