package voyendo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.*;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.model.Category;
import voyendo.model.Company;
import voyendo.model.Labour;
import voyendo.model.Review;
import voyendo.service.CategoryService;
import voyendo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import voyendo.service.ReviewService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ReviewService reviewService;

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

    @GetMapping("/empresas/{id}/cuenta")
    public String infoCuenta(@PathVariable(value="id") Long idCompany, @ModelAttribute ModificarCompanyData modificarCompanyData,
                             Model model, HttpSession session, @ModelAttribute("exito") String exito,
                             @ModelAttribute("error") String error) {
        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

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
        cargarModificarCompanyData(idCompany, modificarCompanyData);
        return "cuentaEmpresa";
    }

    @PostMapping("/empresas/{id}/modificarInfo")
    public String modificarInfoBasicaSubmit(@PathVariable(value="id") Long idCompany, @Valid @ModelAttribute ModificarCompanyData modificarCompanyData,
                                            BindingResult result, Model model, RedirectAttributes flash, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        if (result.hasFieldErrors("name") || result.hasFieldErrors("mail")) {
            flash.addFlashAttribute("error", "No se ha podido actualizar su información.");
            return "redirect:/empresas/" + idCompany + "/cuenta";
        }

        companyService.modificarInfoBasica(idCompany, modificarCompanyData);
        flash.addFlashAttribute("exito", "Información actualizada correctamente.");
        return "redirect:/empresas/" + idCompany + "/cuenta";
    }

    @PostMapping("/empresas/{id}/modificarPassword")
    public String modificarPasswordSubmit(@PathVariable(value="id") Long idCompany, @Valid @ModelAttribute ModificarCompanyData modificarCompanyData,
                                          BindingResult result, Model model, RedirectAttributes flash, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        if (result.hasFieldErrors("password") || result.hasFieldErrors("newPassword") || result.hasFieldErrors("confirmNewPassword")) {
            flash.addFlashAttribute("error", "No se ha podido actualizar su contraseña.");
            return "redirect:/empresas/" + idCompany + "/cuenta";
        }

        if(!modificarCompanyData.getPassword().equals(company.getPassword())){
            flash.addFlashAttribute("error", "Su contraseña actual no coincide.");
        }else if(!modificarCompanyData.getNewPassword().equals(modificarCompanyData.getConfirmNewPassword())) {
            flash.addFlashAttribute("error", "La nueva contraseña no coincide con la confirmación.");
        }else{
            companyService.modificarPassword(idCompany, modificarCompanyData);
            flash.addFlashAttribute("exito", "Contraseña actualizada correctamente.");
        }
        return "redirect:/empresas/" + idCompany + "/cuenta";
    }

    @PostMapping("/empresas/{id}/modificarDetallesEmpresa")
    public String modificarDetallesEmpresaSubmit(@PathVariable(value="id") Long idCompany, @Valid @ModelAttribute ModificarCompanyData modificarCompanyData,
                                                 BindingResult result, Model model, RedirectAttributes flash, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        if (result.hasFieldErrors("startday") || result.hasFieldErrors("finishday") || result.hasFieldErrors("category") || result.hasFieldErrors("category.name")) {
            flash.addFlashAttribute("error", "No se han podido actualizar los detalles de su empresa.");
            return "redirect:/empresas/" + idCompany + "/cuenta";
        }

        Category category = categoryService.findByName(modificarCompanyData.getCategory().getName());
        modificarCompanyData.setCategory(category);
        companyService.modificarDetallesEmpresa(idCompany, modificarCompanyData);
        flash.addFlashAttribute("exito", "Detalles de la empresa actualizados correctamente.");
        return "redirect:/empresas/" + idCompany + "/cuenta";
    }

    @PostMapping("/empresas/{id}/premium")
    public String premium(@PathVariable(value="id") Long idCompany, @ModelAttribute PremiumData premiumData,
                                  Model model, HttpSession session) {
        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        companyService.premium(idCompany, premiumData.isPremium());
        return "redirect:/empresas/" + idCompany + "/estadisticas";
    }

    @GetMapping("/empresas/{id}/estadisticas")
    public String estadisticas(@PathVariable(value="id") Long idCompany, Model model, HttpSession session) {
        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        model.addAttribute("company", company);

        model.addAttribute("topCards", companyService.obtenerCartasEstadisticas(company));
        model.addAttribute("valuesPieChartGender", companyService.obtenerNumeroClientesPorGenero(company));
        model.addAttribute("valuesPieChartAge", companyService.obtenerNumeroClientesPorEdad(company));
        model.addAttribute("valuesPieChartAppointmentsLabour", companyService.obtenerTotalReservasPorServicioActivo(company));
        model.addAttribute("labelsPieChartAppointmentsLabour", companyService.obtenerServicios(company));
        model.addAttribute("historicalAppointments", companyService.obtenerHistoricoReservas(company));
        model.addAttribute("historicalNewCustomers", companyService.obtenerHistoricoNuevosClientes(company));
        return "estadisticas";
    }

    @GetMapping("/empresas/{id}/servicios")
    public String servicios(@PathVariable(value="id") Long idCompany, Model model, HttpSession session,
                            @ModelAttribute("exito") String exito, @ModelAttribute("error") String error) {
        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        model.addAttribute("company", company);
        model.addAttribute("servicios", new ArrayList<Labour>(company.getActivatedLabours()));
        model.addAttribute("labourData", new LabourData());
        model.addAttribute("labourEliminarData", new LabourEliminarData());
        return "servicios";
    }
}
