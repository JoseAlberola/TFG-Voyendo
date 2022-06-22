package voyendo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.util.MultiValueMap;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.AppointmentData;
import voyendo.controller.Data.CrearAppointmentData;
import voyendo.controller.exception.AppointmentNotFoundException;
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
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    CompanyService companyService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    ManagerUserSession managerUserSession;


    @PostMapping("/companies/{idCompany}/appointments/nuevo")
    public String nuevaCita(@PathVariable(value="idCompany") Long idCompany,
                            @ModelAttribute CrearAppointmentData crearAppointmentData, Model model,
                            RedirectAttributes redirectAttr, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        System.out.println(company);
        if(crearAppointmentData.getIdappointment() == 0){  // Crear cita
            if(!appointmentService.nuevaReserva(company, crearAppointmentData)){
                redirectAttr.addFlashAttribute("error", "No se ha podido crear la reserva.");
            }else{
                redirectAttr.addFlashAttribute("exito", "Reserva creada.");
            }
        }else{  // Modificar cita
            if(!appointmentService.modificarCita(company, crearAppointmentData)){
                redirectAttr.addFlashAttribute("error", "No se ha podido modificar la reserva.");
            }else{
                redirectAttr.addFlashAttribute("exito", "Reserva modificada.");
            }
        }
        return "redirect:/companies/" + idCompany + "/home";
     }

    @DeleteMapping("/companies/{idCompany}/appointments/{idAppointment}/eliminar")
    @ResponseBody
    // La anotación @ResponseBody sirve para que la cadena devuelta sea la resupuesta
    // de la petición HTTP, en lugar de una plantilla thymeleaf
    public String eliminarReserva(@PathVariable(value="idCompany") Long idCompany,
                               @PathVariable(value="idAppointment") Long idAppointment, Model model,
                                  RedirectAttributes redirectAttr, HttpSession session) {
        Appointment appointment = appointmentService.findById(idAppointment);
        if (appointment == null) {
            throw new AppointmentNotFoundException();
        }

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        appointmentService.eliminarReserva(idAppointment);

        return "";
    }

    @PostMapping("/appointments/{idAppointment}/mover")
    public String moverCita(@PathVariable(value="idAppointment") Long idAppointment,
                            Model model, @RequestBody JsonNode payload, RedirectAttributes redirectAttr, HttpSession session) {

        Appointment appointment = appointmentService.findById(idAppointment);
        if (appointment == null) {
            throw new AppointmentNotFoundException();
        }

        Long idCompany = appointment.getCompany().getId();
        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        String nuevaFecha = payload.get("date").asText();
        String nuevaHoraInicio = payload.get("starthour").asText();
        String nuevaHoraFin = payload.get("endhour").asText();

        if(appointmentService.moverReserva(idAppointment, nuevaFecha, nuevaHoraInicio, nuevaHoraFin)){
            redirectAttr.addFlashAttribute("exito", "Reserva movida de fecha.");
        }else{
            redirectAttr.addFlashAttribute("error", "No se ha podido mover la reserva.");
        }

        return "redirect:/companies/" + idCompany + "/home";
    }
}

