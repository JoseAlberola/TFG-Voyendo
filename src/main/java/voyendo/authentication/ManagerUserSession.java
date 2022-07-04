package voyendo.authentication;

import voyendo.model.Company;
import voyendo.model.Customer;
import voyendo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import voyendo.service.CustomerService;

import javax.servlet.http.HttpSession;

@Component
public class ManagerUserSession {

    @Autowired
    CompanyService companyService;

    @Autowired
    CustomerService customerService;

    // Añadimos el id de usuario en la sesión HTTP para hacer
    // una autorización sencilla. En los métodos de controllers
    // comprobamos si el id del usuario logeado coincide con el obtenido
    // desde la URL
    public void logearUsuario(HttpSession session, Long idUsuario) {
        session.setAttribute("idUsuarioLogeado", idUsuario);
    }

    public void logout(HttpSession session) {
        session.setAttribute("idUsuarioLogeado", null);
    }

    public boolean comprobarUsuarioLogeado(HttpSession session, Long idUsuario) {
        Long idUsuarioLogeado = (Long) session.getAttribute("idUsuarioLogeado");
        if(idUsuario == null || idUsuarioLogeado == null || !idUsuario.equals(idUsuarioLogeado))
            throw new UsuarioNoLogeadoException();
        return true;
    }

    public Long usuarioLogeado(HttpSession session) {
        return (Long) session.getAttribute("idUsuarioLogeado");
    }

    public boolean esEmpresa(Long idUsuario){
        Company company = companyService.findById(idUsuario);
        if (company == null) {
            return false;
        }
        return true;
    }

    public boolean esCliente(Long idUsuario){
        Customer customer = customerService.findById(idUsuario);
        if (customer == null) {
            return false;
        }
        return true;
    }

    public String encryptPassword(String password){
        // return BCrypt.hashpw(password, BCrypt.gensalt());
        return password;
    }

    public boolean decryptPassword(String password, String hashed){
        // return BCrypt.checkpw(password, hashed);
        return true;
    }
}
