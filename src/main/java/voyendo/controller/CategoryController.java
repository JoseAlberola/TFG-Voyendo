package voyendo.controller;

import voyendo.authentication.ManagerUserSession;
import voyendo.controller.exception.EquipoNotFoundException;
import voyendo.controller.exception.UsuarioNotFoundException;
import voyendo.model.Category;
import voyendo.model.Company;
import voyendo.service.CategoryService;
import voyendo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CompanyService companyService;

    @Autowired
    ManagerUserSession managerUserSession;

    @GetMapping("/equipos")
    public String listarCategorias(Model model, HttpSession session) {
        Long idCompany = managerUserSession.usuarioLogeado(session);
        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if(company == null){
            throw new UsuarioNotFoundException();
        }
        model.addAttribute("usuario", company);

        Iterable<Category> categorias = categoryService.findAllOrderedByName();
        model.addAttribute("equipos", categorias);
        return "listaEquipos";
    }

    @GetMapping("/equipos/nuevo")
    public String formNuevaCategoria(@ModelAttribute CategoryData categoryData, Model model, HttpSession session) {
        Long idUsuario = managerUserSession.usuarioLogeado(session);
        managerUserSession.comprobarUsuarioLogeado(session, idUsuario);
        Company company = companyService.findById(idUsuario);
        if (company == null) {
            throw new UsuarioNotFoundException();
        }
        model.addAttribute("usuario", company);
        return "formNuevoEquipo";
    }

    @PostMapping("/equipos/nuevo")
    public String nuevaCategoria(@ModelAttribute CategoryData categoryData, Model model,
                                 RedirectAttributes flash, HttpSession session) {

        Long idCompany = managerUserSession.usuarioLogeado(session);
        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new UsuarioNotFoundException();
        }

        categoryService.crearCategoria(categoryData.getNombre());
        flash.addFlashAttribute("mensaje", "Categoría creada correctamente");
        return "redirect:/equipos";
    }

    @GetMapping("/equipos/{id}/editar")
    public String formEditaCategoria(@PathVariable(value="id") Long idCategory, @ModelAttribute CategoryData categoryData,
                                 Model model, HttpSession session) {

        Category category = categoryService.findById(idCategory);
        if (category == null) {
            throw new EquipoNotFoundException();
        }

        Long idCompany = managerUserSession.usuarioLogeado(session);
        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new UsuarioNotFoundException();
        }

        model.addAttribute("usuario", company);
        model.addAttribute("equipo", category);
        categoryData.setNombre(category.getName());
        return "formEditarEquipo";
    }

    @PostMapping("/equipos/{id}/editar")
    public String grabaCategoriaModificada(@PathVariable(value="id") Long idCategory, @ModelAttribute CategoryData categoryData,
                                       Model model, RedirectAttributes flash, HttpSession session) {

        Category category = categoryService.findById(idCategory);
        if (category == null) {
            throw new EquipoNotFoundException();
        }

        categoryService.modificaCategoria(idCategory, categoryData.getNombre());
        flash.addFlashAttribute("mensaje", "Categoría modificada correctamente");
        return "redirect:/equipos";
    }

    @DeleteMapping("/equipos/{id}")
    @ResponseBody
    // La anotación @ResponseBody sirve para que la cadena devuelta sea la resupuesta
    // de la petición HTTP, en lugar de una plantilla thymeleaf
    public String borrarCategoria(@PathVariable(value="id") Long idCategory, HttpSession session) {

        Category category = categoryService.findById(idCategory);
        if (category == null) {
            throw new EquipoNotFoundException();
        }

        categoryService.borraCategoria(idCategory);
        return "";
    }

}
