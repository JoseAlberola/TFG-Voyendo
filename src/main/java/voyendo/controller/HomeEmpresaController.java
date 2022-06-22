package voyendo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.CrearAppointmentData;
import voyendo.controller.exception.UsuarioNotFoundException;
import voyendo.model.Appointment;
import voyendo.model.Company;
import voyendo.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping("/companies/{id}/home")
    public String home(@PathVariable(value="id") Long idCompany, Model model, HttpSession session,
                       @ModelAttribute("exito") String exito, @ModelAttribute("error") String error) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new UsuarioNotFoundException();
        }
        model.addAttribute("company", company);
        model.addAttribute("crearAppointmentData", new CrearAppointmentData());
        List<ReservaCalendario> reservasCalendario = appointmentService.convertirAppointmentsAReservasCalendario(companyService.obtenerReservas(company));
        model.addAttribute("reservasCalendario", reservasCalendario);
        return "homeEmpresa";
    }

}
