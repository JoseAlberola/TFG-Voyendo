package voyendo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.*;
import voyendo.controller.exception.AppointmentNotFoundException;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.controller.exception.CustomerNotFoundException;
import voyendo.controller.exception.LabourNotFoundException;
import voyendo.model.*;
import voyendo.service.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CustomerController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    ManagerUserSession managerUserSession;

    private void cargarRegistroDataCustomer(Customer customer, RegistroDataCustomer registroDataCustomer){
        registroDataCustomer.setUsername(customer.getUsername());
        registroDataCustomer.setMail(customer.getMail());
        registroDataCustomer.setPassword("");
        registroDataCustomer.setNewPassword("");
        registroDataCustomer.setConfirmNewPassword("");
        registroDataCustomer.setName(customer.getName());
        registroDataCustomer.setPhone(customer.getPhone());
        registroDataCustomer.setGender(customer.getGender());
        registroDataCustomer.setBirthday(customer.getBirthdayString());
    }

    @GetMapping("/clientes/{id}/cuenta")
    public String cuentaCliente(@PathVariable(value="id") Long idCustomer, Model model, HttpSession session,
                                @ModelAttribute RegistroDataCustomer registroDataCustomer,
                                @ModelAttribute("exito") String exito, @ModelAttribute("error") String error) {

        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);
        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        cargarRegistroDataCustomer(customer, registroDataCustomer);
        model.addAttribute("customer", customer);
        return "cuentaCliente";
    }

    @PostMapping("/clientes/{id}/modificar")
    public String modificarInfoCliente(@PathVariable(value="id") Long idCustomer, @Valid @ModelAttribute RegistroDataCustomer registroDataCustomer,
                                       BindingResult result, Model model, RedirectAttributes flash, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);
        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        if (result.hasFieldErrors("name") || result.hasFieldErrors("mail")) {
            flash.addFlashAttribute("error", "No se ha podido actualizar su información.");
            return "redirect:/clientes/" + idCustomer + "/cuenta";
        }

        customerService.modificarInfo(idCustomer, registroDataCustomer);
        flash.addFlashAttribute("exito", "Información actualizada correctamente.");
        return "redirect:/clientes/" + idCustomer + "/cuenta";
    }

    @PostMapping("/clientes/{id}/modificarPassword")
    public String modificarPasswordSubmit(@PathVariable(value="id") Long idCustomer, @Valid @ModelAttribute RegistroDataCustomer registroDataCustomer,
                                          BindingResult result, Model model, RedirectAttributes flash, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);
        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        if (result.hasFieldErrors("password") || result.hasFieldErrors("newPassword") || result.hasFieldErrors("confirmNewPassword")) {
            flash.addFlashAttribute("error", "No se ha podido actualizar su contraseña.");
            return "redirect:/clientes/" + idCustomer + "/cuenta";
        }

        if(!registroDataCustomer.getPassword().equals(customer.getPassword())){
            flash.addFlashAttribute("error", "Su contraseña actual no coincide.");
        }else if(!registroDataCustomer.getNewPassword().equals(registroDataCustomer.getConfirmNewPassword())) {
            flash.addFlashAttribute("error", "La nueva contraseña no coincide con la confirmación.");
        }else{
            customerService.modificarPassword(idCustomer, registroDataCustomer);
            flash.addFlashAttribute("exito", "Contraseña actualizada correctamente.");
        }
        return "redirect:/clientes/" + idCustomer + "/cuenta";
    }

    @GetMapping("/empresas/{id}/detalles")
    public String detallesEmpresa(@PathVariable(value="id") Long idCompany, Model model, HttpSession session,
                                  @ModelAttribute("exito") String exito, @ModelAttribute("error") String error,
                                  @ModelAttribute CrearReviewData crearReviewData,
                                  @ModelAttribute ReviewEliminarData reviewEliminarData) {

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        model.addAttribute("company", company);

        int currentPage = 1;
        int pageSize = 3;

        Page<Review> reviewPage = reviewService.findPaginated(idCompany, PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("reviewPage", reviewPage);

        int totalPages = reviewPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("paginaActual", currentPage);
        }

        Iterable<Category> categorias = categoryService.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("company", company);
        model.addAttribute("reviews", company.getReviews());
        model.addAttribute("positiveNumber", company.getPositiveReviews());
        model.addAttribute("negativeNumber", company.getNegativeReviews());
        model.addAttribute("neutralNumber", company.getNeutralReviews());
        model.addAttribute("valoracionMedia", company.valoracionMedia());

        Long idCustomer = managerUserSession.usuarioLogeado(session);
        if(idCustomer == null){
            throw new CustomerNotFoundException();
        }else{
            Customer customer = customerService.findById(idCustomer);
            model.addAttribute("customer", customer);
            Review reviewHecha = customer.getReviewEmpresa(company.getId());
            if(reviewHecha != null ){
                crearReviewData.setIdreview(reviewHecha.getId());
                crearReviewData.setComentario(reviewHecha.getText());
                crearReviewData.setValuation(reviewHecha.getValuation());
                reviewEliminarData.setReviewid(reviewHecha.getId());
            }
        }

        return "detallesEmpresa";
    }

    @GetMapping("/empresas/{id}/horario")
    public String horarioEmpresa(@PathVariable(value="id") Long idCompany, Model model, HttpSession session,
                       @ModelAttribute("exito") String exito, @ModelAttribute("error") String error) {

        Long idCustomer = managerUserSession.usuarioLogeado(session);
        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);
        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        model.addAttribute("company", company);
        model.addAttribute("customer", customer);
        model.addAttribute("crearAppointmentData", new CrearAppointmentData());
        List<ReservaCalendario> reservasCalendario =
                appointmentService.convertirAppointmentsAReservasCalendario(companyService.obtenerReservas(company));
        model.addAttribute("reservasCalendario", reservasCalendario);
        return "horarioEmpresa";
    }

    @GetMapping("/clientes/{id}/reservas")
    public String reservasCliente(@PathVariable(value="id") Long idCustomer, Model model, HttpSession session,
                                  @ModelAttribute("exito") String exito, @ModelAttribute("error") String error,
                                  @RequestParam("tipo") Optional<String> tipo, @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {

        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);
        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        List<Appointment> reservas;
        String currentTipo = tipo.orElse("");
        String tipoLista = "";
        if(currentTipo.equals("") || currentTipo.equals("todas")){
            reservas = appointmentService.citasDelCliente(idCustomer);
            tipoLista = "todas";
        }else if(currentTipo.equals("proximas")){
            reservas = appointmentService.citasProximasCliente(idCustomer);
            tipoLista = "proximas";
        }else{
            reservas = appointmentService.citasAntiguasCliente(idCustomer);
            tipoLista = "antiguas";
        }

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(6);

        Page<Appointment> listPage = appointmentService.paginar(PageRequest.of(currentPage - 1, pageSize), reservas);

        model.addAttribute("listPage", listPage);

        int totalPages = listPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("paginaActual", currentPage);
        }

        model.addAttribute("customer", customer);
        model.addAttribute("reservas", reservas);
        model.addAttribute("tipoLista", tipoLista);
        return "misReservas";
    }

    @PostMapping("/clientes/{idCustomer}/reservas/{idReserva}/cancelar")
    public String cancelarReserva(@PathVariable(value="idCustomer") Long idCustomer, @PathVariable(value="idReserva") Long idReserva,
                                  Model model, RedirectAttributes redirectAttr, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);
        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        Appointment appointment = appointmentService.findById(idReserva);
        if(appointment == null){
            throw new AppointmentNotFoundException();
        }else if(appointment instanceof NormalAppointment && ((NormalAppointment) appointment).getCustomer().equals(customer)){
            if(appointmentService.eliminarReserva(idReserva)){
                redirectAttr.addFlashAttribute("exito", "Reserva cancelada.");
            }else {
                redirectAttr.addFlashAttribute("error", "No se ha podido cancelar la reserva.");
            }
        }

        return "redirect:/clientes/" + idCustomer + "/reservas";
    }
}
