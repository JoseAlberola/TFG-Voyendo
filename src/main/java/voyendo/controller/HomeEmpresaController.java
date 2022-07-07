package voyendo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.CrearAppointmentData;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.controller.exception.CustomerNotFoundException;
import voyendo.model.Company;
import voyendo.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeEmpresaController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    ManagerUserSession managerUserSession;

    @GetMapping("/empresas/{id}/home")
    public String home(@PathVariable(value="id") Long idCompany, Model model, HttpSession session,
                       @ModelAttribute("exito") String exito, @ModelAttribute("error") String error) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        model.addAttribute("company", company);
        model.addAttribute("crearAppointmentData", new CrearAppointmentData());
        List<ReservaCalendario> reservasCalendario =
                appointmentService.convertirAppointmentsAReservasCalendario(companyService.obtenerReservas(company));
        model.addAttribute("reservasCalendario", reservasCalendario);
        return "homeEmpresa";
    }

}
