package voyendo.controller;

import voyendo.authentication.ManagerUserSession;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.controller.exception.UsuarioNotFoundException;
import voyendo.model.Appointment;
import voyendo.model.Company;
import voyendo.service.AppointmentService;
import voyendo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AppointmentController {

    @Autowired
    CompanyService companyService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    ManagerUserSession managerUserSession;


    @GetMapping("/usuarios/{id}/tareas/nueva")
    public String formNuevaCita(@PathVariable(value="id") Long idCompany,
                                @ModelAttribute AppointmentData appointmentData, Model model,
                                HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new UsuarioNotFoundException();
        }
        model.addAttribute("usuario", company);
        return "formNuevaTarea";
    }

    @PostMapping("/companies/{idCompany}/appointments/nuevo")
    public String nuevaCita(@PathVariable(value="idCompany") Long idCompany,
                            @ModelAttribute CrearAppointmentData crearAppointmentData, Model model,
                            RedirectAttributes flash, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        System.out.println("JOSELITO");
        return "redirect:/companies/1/home";
     }

     /*
    @GetMapping("/usuarios/{id}/tareas")
    public String listadoCitas(@PathVariable(value="id") Long idCompany, Model model, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new UsuarioNotFoundException();
        }
        List<Appointment> appointments = appointmentService.allCitasEmpresa(idCompany);
        model.addAttribute("usuario", company);
        model.addAttribute("tareas", appointments);
        return "home";
    }
     */

    @GetMapping("/tareas/{id}/editar")
    public String formEditaCita(@PathVariable(value="id") Long idAppointment, @ModelAttribute AppointmentData appointmentData,
                                 Model model, HttpSession session) {

        Appointment appointment = appointmentService.findById(idAppointment);
        if (appointment == null) {
            throw new CompanyNotFoundException();
        }

        managerUserSession.comprobarUsuarioLogeado(session, appointment.getCompany().getId());

        Company company = companyService.findById(appointment.getCompany().getId());
        if (company == null) {
            throw new UsuarioNotFoundException();
        }

        model.addAttribute("usuario", company);
        model.addAttribute("tarea", appointment);
        appointmentData.setDate(appointment.getDate());
        return "formEditarTarea";
    }

    @PostMapping("/tareas/{id}/editar")
    public String grabaCitaModificada(@PathVariable(value="id") Long idAppointment, @ModelAttribute AppointmentData appointmentData,
                                       Model model, RedirectAttributes flash, HttpSession session) {
        Appointment appointment = appointmentService.findById(idAppointment);
        if (appointment == null) {
            throw new CompanyNotFoundException();
        }

        Long idCompany = appointment.getCompany().getId();

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        appointmentService.modificaCita(idAppointment, appointmentData.getDate());
        flash.addFlashAttribute("mensaje", "Cita modificada correctamente");
        return "redirect:/usuarios/" + appointment.getCompany().getId() + "/tareas";
    }

    @DeleteMapping("/tareas/{id}")
    @ResponseBody
    // La anotación @ResponseBody sirve para que la cadena devuelta sea la resupuesta
    // de la petición HTTP, en lugar de una plantilla thymeleaf
    public String borrarCita(@PathVariable(value="id") Long idAppointment, RedirectAttributes flash, HttpSession session) {
        Appointment appointment = appointmentService.findById(idAppointment);
        if (appointment == null) {
            throw new CompanyNotFoundException();
        }

        managerUserSession.comprobarUsuarioLogeado(session, appointment.getCompany().getId());

        appointmentService.borraCita(idAppointment);
        return "";
    }
}

