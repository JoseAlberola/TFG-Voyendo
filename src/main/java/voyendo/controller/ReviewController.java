package voyendo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.*;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.controller.exception.CustomerNotFoundException;
import voyendo.controller.exception.LabourNotFoundException;
import voyendo.controller.exception.ReviewNotFoundException;
import voyendo.model.*;
import voyendo.service.CategoryService;
import voyendo.service.CompanyService;
import voyendo.service.CustomerService;
import voyendo.service.ReviewService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ManagerUserSession managerUserSession;

    private void cargarModificarCompanyData(Long idCompany, ModificarCompanyData modificarCompanyData){
        Company company = companyService.findById(idCompany);
        modificarCompanyData.setUsername(company.getUsername());
        modificarCompanyData.setName(company.getName());
        modificarCompanyData.setMail(company.getMail());
        modificarCompanyData.setPhone(company.getPhone());
        modificarCompanyData.setAddress(company.getAddress());
        modificarCompanyData.setPassword("");
        modificarCompanyData.setNewPassword("");
        modificarCompanyData.setConfirmNewPassword("");
        modificarCompanyData.setStartday(company.getStartday());
        modificarCompanyData.setFinishday(company.getFinishday());
        modificarCompanyData.setCategory(company.getCategory());
    }

    @RequestMapping(value = "/empresas/{id}/reviews", method = RequestMethod.GET)
    public String listadoReviews(@PathVariable(value="id") Long idCompany, @ModelAttribute ModificarCompanyData modificarCompanyData,
                                 Model model, HttpSession session,
                                 @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);

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

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        Iterable<Category> categorias = categoryService.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("company", company);
        model.addAttribute("reviews", company.getReviews());
        model.addAttribute("positiveNumber", company.getPositiveReviews());
        model.addAttribute("negativeNumber", company.getNegativeReviews());
        model.addAttribute("neutralNumber", company.getNeutralReviews());
        model.addAttribute("valoracionMedia", company.valoracionMedia());
        cargarModificarCompanyData(idCompany, modificarCompanyData);
        return "cuentaEmpresa";
    }


    @RequestMapping(value = "/empresas/{id}/detalles/reviews", method = RequestMethod.GET)
    public String listadoReviewsDetallesEmpresa(@PathVariable(value="id") Long idCompany, Model model, HttpSession session,
                                  @ModelAttribute("exito") String exito, @ModelAttribute("error") String error,
                                  @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                                  @ModelAttribute CrearReviewData crearReviewData,
                                  @ModelAttribute ReviewEliminarData reviewEliminarData) {

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        model.addAttribute("company", company);

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);

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

    @PostMapping("/empresas/{idCompany}/reviews/nueva")
    public String crearEditarLabour(@PathVariable(value="idCompany") Long idCompany,
                                    @ModelAttribute CrearReviewData crearReviewData, Model model,
                                    RedirectAttributes redirectAttr, HttpSession session) {

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

        if(crearReviewData.getIdreview() == null){  // Crear review
            if(!reviewService.crearReview(company, customer, crearReviewData)){
                redirectAttr.addFlashAttribute("error", "No se ha podido crear la review.");
            }else{
                redirectAttr.addFlashAttribute("exito", "Review creada.");
            }
        }else{  // Modificar review
            if(!reviewService.modificarReview(crearReviewData)){
                redirectAttr.addFlashAttribute("error", "No se ha podido modificar la review.");
            }else{
                redirectAttr.addFlashAttribute("exito", "Review modificada.");
            }
        }

        return "redirect:/empresas/" + idCompany + "/detalles";
    }

    @PostMapping("/empresas/{idCompany}/reviews/eliminar")
    // La anotación @ResponseBody sirve para que la cadena devuelta sea la resupuesta
    // de la petición HTTP, en lugar de una plantilla thymeleaf
    public String eliminarReview(@PathVariable(value="idCompany") Long idCompany,
                                   @ModelAttribute ReviewEliminarData reviewEliminarData, Model model,
                                   RedirectAttributes redirectAttr, HttpSession session) {

        Long idReview = reviewEliminarData.getReviewid();
        Review review = reviewService.findById(idReview);
        if (review == null) {
            throw new ReviewNotFoundException();
        }

        Long idCustomer = managerUserSession.usuarioLogeado(session);
        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);
        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        if(!reviewService.eliminarReview(idReview)){
            redirectAttr.addFlashAttribute("error", "No se ha podido eliminar la review.");
        }else{
            redirectAttr.addFlashAttribute("exito", "Review eliminada.");
        }

        return "redirect:/empresas/" + idCompany + "/detalles";
    }

}
