package voyendo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.exception.UsuarioNotFoundException;
import voyendo.model.Appointment;
import voyendo.model.Category;
import voyendo.model.Company;
import voyendo.model.Customer;
import voyendo.service.CategoryService;
import voyendo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import voyendo.service.CustomerService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ManagerUserSession managerUserSession;

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {

        Long idUsuario = managerUserSession.usuarioLogeado(session);
        managerUserSession.comprobarUsuarioLogeado(session, idUsuario);

        Customer customer = customerService.findById(idUsuario);
        if (customer == null) {
            throw new UsuarioNotFoundException();
        }
        Iterable<Category> categorias = categoryService.findAll();
        model.addAttribute("usuario", customer);
        model.addAttribute("categorias", categorias);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model, HttpSession session) {
        Long idUsuario = managerUserSession.usuarioLogeado(session);
        if(idUsuario == null){
            model.addAttribute("usuario", null);
        }else if(managerUserSession.esEmpresa(idUsuario)){
            Company company = companyService.findById(idUsuario);
            model.addAttribute("usuario", company);
        }else{
            Customer customer = customerService.findById(idUsuario);
            model.addAttribute("usuario", customer);
        }
        return "about";
    }

}
