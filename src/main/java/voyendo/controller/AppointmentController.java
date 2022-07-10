package voyendo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.transaction.annotation.Transactional;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.CrearAppointmentData;
import voyendo.controller.exception.AppointmentNotFoundException;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.controller.exception.CustomerNotFoundException;
import voyendo.model.Appointment;
import voyendo.model.Company;
import voyendo.model.Customer;
import voyendo.service.AppointmentService;
import voyendo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import voyendo.service.CustomerService;
import voyendo.service.exception.DateFormatException;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Controller
public class AppointmentController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    ManagerUserSession managerUserSession;

    public Date convertToDate(String fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(fecha);
        } catch (ParseException e) {
            throw new DateFormatException("Excepción al convertir el string: " + fecha + " a Date.");
        }
    }

    public Date getTodayDateWithoutTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            throw new DateFormatException("Excepción al obtener la fecha de hoy");
        }
    }

    @PostMapping("/empresas/{idCompany}/reservas/nueva")
    public String crearEditarCita(@PathVariable(value="idCompany") Long idCompany,
                            @ModelAttribute CrearAppointmentData crearAppointmentData, Model model,
                            RedirectAttributes redirectAttr, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

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
        return "redirect:/empresas/" + idCompany + "/home";
    }

    @PostMapping("/clientes/{idCustomer}/empresas/{idCompany}/reservas/nueva")
    public String crearCitaPorCliente(@PathVariable(value="idCustomer") Long idCustomer,
                                      @PathVariable(value="idCompany") Long idCompany,
                                    @ModelAttribute CrearAppointmentData crearAppointmentData, Model model,
                                  RedirectAttributes redirectAttr, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);
        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        LocalTime horaInicioCita = LocalTime.parse(crearAppointmentData.getStarthour());
        Date fechaCita = convertToDate(crearAppointmentData.getStart());
        Date hoy = getTodayDateWithoutTime();
        if(fechaCita.equals(hoy) && horaInicioCita.isBefore(LocalTime.now())){
            redirectAttr.addFlashAttribute("error", "No se ha podido crear la reserva.");
        }else{
            if(!appointmentService.nuevaReserva(company, crearAppointmentData)){
                redirectAttr.addFlashAttribute("error", "No se ha podido crear la reserva.");
            }else{
                redirectAttr.addFlashAttribute("exito", "Reserva creada.");
            }
        }

        return "redirect:/empresas/" + idCompany + "/horario";
    }

    @DeleteMapping("/empresas/{idCompany}/reservas/{idAppointment}/eliminar")
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

    @PostMapping("/reservas/{idAppointment}/mover")
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

        return "redirect:/empresas/" + idCompany + "/home";
    }
}

