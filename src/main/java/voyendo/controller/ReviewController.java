package voyendo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.CategoryData;
import voyendo.controller.Data.ModificarCompanyData;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.controller.exception.EquipoNotFoundException;
import voyendo.controller.exception.UsuarioNotFoundException;
import voyendo.model.Category;
import voyendo.model.Company;
import voyendo.model.Review;
import voyendo.service.CategoryService;
import voyendo.service.CompanyService;
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

    @RequestMapping(value = "/companies/{id}/reviews", method = RequestMethod.GET)
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

}
