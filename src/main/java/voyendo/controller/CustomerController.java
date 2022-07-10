package voyendo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.CrearAppointmentData;
import voyendo.controller.Data.CrearReviewData;
import voyendo.controller.Data.ReviewEliminarData;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.controller.exception.CustomerNotFoundException;
import voyendo.model.Category;
import voyendo.model.Company;
import voyendo.model.Customer;
import voyendo.model.Review;
import voyendo.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;
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
}
