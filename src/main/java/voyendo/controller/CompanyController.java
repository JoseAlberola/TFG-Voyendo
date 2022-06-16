package voyendo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.model.Category;
import voyendo.model.Company;
import voyendo.service.CategoryService;
import voyendo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

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

    @GetMapping("/companies/{id}/cuenta")
    public String infoCuenta(@PathVariable(value="id") Long idCompany, @ModelAttribute ModificarCompanyData modificarCompanyData,
                             Model model, HttpSession session) {
        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        Iterable<Category> categorias = categoryService.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("company", company);
        cargarModificarCompanyData(idCompany, modificarCompanyData);
        return "cuentaEmpresa";
    }

    @PostMapping("/companies/{id}/modificarInfoBasica")
    public String modificarInfoBasicaSubmit(@PathVariable(value="id") Long idCompany, @Valid @ModelAttribute ModificarCompanyData modificarCompanyData,
                                            BindingResult result, Model model, RedirectAttributes flash, HttpSession session) {
        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        if (result.hasFieldErrors("name") || result.hasFieldErrors("mail")) {
            Iterable<Category> categorias = categoryService.findAll();
            model.addAttribute("categorias", categorias);
            model.addAttribute("company", company);
            cargarModificarCompanyData(idCompany, modificarCompanyData);
            flash.addFlashAttribute("mensaje", "No se ha podido actualizar su información.");
            return "redirect:/companies/" + idCompany + "/cuenta";
        }

        companyService.modificarInfoBasica(idCompany, modificarCompanyData);
        flash.addFlashAttribute("mensaje", "Información actualizada correctamente.");
        return "redirect:/companies/" + idCompany + "/cuenta";
    }

    @PostMapping("/companies/{id}/modificarPassword")
    public String modificarPasswordSubmit(@PathVariable(value="id") Long idCompany, @Valid @ModelAttribute ModificarCompanyData modificarCompanyData,
                                          BindingResult result, Model model, RedirectAttributes flash, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        if (result.hasFieldErrors("password") || result.hasFieldErrors("newPassword") || result.hasFieldErrors("confirmNewPassword")) {
            Iterable<Category> categorias = categoryService.findAll();
            model.addAttribute("categorias", categorias);
            model.addAttribute("company", company);
            cargarModificarCompanyData(idCompany, modificarCompanyData);
            flash.addFlashAttribute("mensaje", "No se ha podido actualizar su contraseña.");
            return "redirect:/companies/" + idCompany + "/cuenta";
        }

        if(!modificarCompanyData.getPassword().equals(company.getPassword())){
            flash.addFlashAttribute("mensaje", "Error. Su contraseña actual no coincide.");
        }else if(!modificarCompanyData.getNewPassword().equals(modificarCompanyData.getConfirmNewPassword())) {
            flash.addFlashAttribute("mensaje", "Error. La nueva contraseña no coincide con la confirmación.");
        }else{
            companyService.modificarPassword(idCompany, modificarCompanyData);
            flash.addFlashAttribute("mensaje", "Contraseña actualizada correctamente.");
        }
        return "redirect:/companies/" + idCompany + "/cuenta";
    }

    @PostMapping("/companies/{id}/modificarDetallesEmpresa")
    public String modificarDetallesEmpresaSubmit(@PathVariable(value="id") Long idCompany, @Valid @ModelAttribute ModificarCompanyData modificarCompanyData,
                                                 BindingResult result, Model model, RedirectAttributes flash, HttpSession session) {

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        if (result.hasFieldErrors("startday") || result.hasFieldErrors("finishday") || result.hasFieldErrors("category") || result.hasFieldErrors("category.name")) {
            Iterable<Category> categorias = categoryService.findAll();
            model.addAttribute("categorias", categorias);
            model.addAttribute("company", company);
            cargarModificarCompanyData(idCompany, modificarCompanyData);
            flash.addFlashAttribute("mensaje", "No se han podido actualizar los detalles de su empresa.");
            return "redirect:/companies/" + idCompany + "/cuenta";
        }

        Category category = categoryService.findByName(modificarCompanyData.getCategory().getName());
        modificarCompanyData.setCategory(category);
        companyService.modificarDetallesEmpresa(idCompany, modificarCompanyData);
        flash.addFlashAttribute("mensaje", "Detalles de la empresa actualizados correctamente.");
        return "redirect:/companies/" + idCompany + "/cuenta";
    }

    @PostMapping("/companies/{id}/premium")
    public String premium(@PathVariable(value="id") Long idCompany, @ModelAttribute PremiumData premiumData,
                                  Model model, HttpSession session) {
        managerUserSession.comprobarUsuarioLogeado(session, idCompany);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        companyService.premium(idCompany, premiumData.isPremium());
        return "redirect:/companies/" + idCompany + "/estadisticas";
    }

    @GetMapping("/companies/{id}/estadisticas")
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
        model.addAttribute("valuesPieChartAppointmentsLabour", companyService.obtenerTotalReservasPorServicio(company));
        model.addAttribute("labelsPieChartAppointmentsLabour", companyService.obtenerServicios(company));
        model.addAttribute("historicalAppointments", companyService.obtenerHistoricoReservas(company));
        model.addAttribute("historicalNewCustomers", companyService.obtenerHistoricoNuevosClientes(company));
        return "estadisticas";
    }
}
