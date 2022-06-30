package voyendo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.CrearAppointmentData;
import voyendo.controller.Data.LabourData;
import voyendo.controller.Data.LabourEliminarData;
import voyendo.controller.exception.AppointmentNotFoundException;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.controller.exception.LabourNotFoundException;
import voyendo.model.Appointment;
import voyendo.model.Company;
import voyendo.model.Labour;
import voyendo.service.AppointmentService;
import voyendo.service.CompanyService;
import voyendo.service.LabourService;

import javax.servlet.http.HttpSession;

@Controller
public class LabourController {

    @Autowired
    CompanyService companyService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    LabourService labourService;

    @Autowired
    ManagerUserSession managerUserSession;


    @PostMapping("/companies/{idCompany}/labours/nuevo")
    public String crearEditarLabour(@PathVariable(value="idCompany") Long idCompany,
                                    @ModelAttribute LabourData labourData, Model model,
                                    RedirectAttributes redirectAttr, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        if(labourData.getIdlabour() == 0){  // Crear labour
            if(!labourService.crearServicio(company, labourData)){
                redirectAttr.addFlashAttribute("error", "No se ha podido crear el servicio.");
            }else{
                redirectAttr.addFlashAttribute("exito", "Nuevo servicio creado.");
            }
        }else{  // Modificar servicio
            if(!labourService.modificarServicio(company, labourData)){
                redirectAttr.addFlashAttribute("error", "No se ha podido modificar el servicio.");
            }else{
                redirectAttr.addFlashAttribute("exito", "Servicio modificado.");
            }
        }

        return "redirect:/companies/" + idCompany + "/servicios";
    }

    @PostMapping("/companies/{idCompany}/labours/eliminar")
    // La anotación @ResponseBody sirve para que la cadena devuelta sea la resupuesta
    // de la petición HTTP, en lugar de una plantilla thymeleaf
    public String eliminarServicio(@PathVariable(value="idCompany") Long idCompany,
                                   @ModelAttribute LabourEliminarData labourEliminarData, Model model,
                                   RedirectAttributes redirectAttr, HttpSession session) {

        Long idLabour = labourEliminarData.getLabourid();
        Labour labour = labourService.findById(idLabour);
        if (labour == null) {
            throw new LabourNotFoundException();
        }

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        if(!labourService.eliminarServicio(idLabour)){
            redirectAttr.addFlashAttribute("error", "No se ha podido eliminar el servicio.");
        }else{
            redirectAttr.addFlashAttribute("exito", "Servicio eliminado.");
        }

        return "redirect:/companies/" + idCompany + "/servicios";
    }

}

