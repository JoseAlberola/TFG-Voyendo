package voyendo.controller;

import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.LoginData;
import voyendo.controller.Data.RegistroDataCompany;
import voyendo.controller.Data.RegistroDataCustomer;
import voyendo.model.Company;
import voyendo.model.Customer;
import voyendo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import voyendo.service.CustomerService;
import voyendo.service.LoginStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ManagerUserSession managerUserSession;

    @GetMapping("/")
    public String home(Model model) {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginData", new LoginData());
        return "formLogin";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute LoginData loginData, Model model, HttpSession session) {

        // Llamada al servicio para comprobar si el login es correcto
        LoginStatus loginCompanyStatus = companyService.login(loginData.getUsername(), loginData.getPassword());
        LoginStatus loginCustomerStatus = customerService.login(loginData.getUsername(), loginData.getPassword());

        if (loginCompanyStatus == LoginStatus.LOGIN_OK) {
            Company company = companyService.findByUsername(loginData.getUsername());
            managerUserSession.logearUsuario(session, company.getId());
            return "redirect:/empresas/" + company.getId() + "/home";
        }else if(loginCustomerStatus == LoginStatus.LOGIN_OK){
            Customer customer = customerService.findByUsername(loginData.getUsername());
            managerUserSession.logearUsuario(session, customer.getId());
            return "redirect:/clientes/" + customer.getId() + "/home";
        }else if(loginCompanyStatus == LoginStatus.ERROR_PASSWORD || loginCustomerStatus == LoginStatus.ERROR_PASSWORD){
            model.addAttribute("error", "Contraseña incorrecta");
            return "formLogin";
        } else if (loginCompanyStatus == LoginStatus.USER_NOT_FOUND || loginCustomerStatus == LoginStatus.USER_NOT_FOUND) {
            model.addAttribute("error", "No existe ese usuario");
            return "formLogin";
        }
        return "formLogin";
    }

    @GetMapping("/registro")
    public String registroForm(Model model) {
        model.addAttribute("registroDataCustomer", new RegistroDataCustomer());
        model.addAttribute("registroDataCompany", new RegistroDataCompany());
        return "formRegistro";
    }

   @PostMapping("/registroCustomer")
   public String registroCustomerSubmit(@Valid RegistroDataCustomer registroDataCustomer, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "formRegistro";
        }

        if (companyService.findByUsername(registroDataCustomer.getUsername()) != null || customerService.findByUsername(registroDataCustomer.getUsername()) != null) {
            model.addAttribute("registroDataCustomer", registroDataCustomer);
            model.addAttribute("registroDataCompany", new RegistroDataCompany());
            model.addAttribute("error", "El usuario " + registroDataCustomer.getUsername() + " ya existe");
            return "formRegistro";
        }

        Customer customer = customerService.crearCliente(registroDataCustomer);
        customerService.registrar(customer);
        return "redirect:/login";
   }

    @PostMapping("/registroCompany")
    public String registroCompanySubmit(@Valid RegistroDataCompany registroDataCompany, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "formRegistro";
        }

        if (companyService.findByUsername(registroDataCompany.getUsername()) != null || customerService.findByUsername(registroDataCompany.getUsername()) != null) {
            model.addAttribute("registroDataCustomer", new RegistroDataCustomer());
            model.addAttribute("registroDataCompany", registroDataCompany);
            model.addAttribute("error", "El usuario " + registroDataCompany.getUsername() + " ya existe");
            return "formRegistro";
        }

        Company company = companyService.crearEmpresa(registroDataCompany);
        companyService.registrar(company);
        return "redirect:/login";
    }

   @GetMapping("/logout")
   public String logout(HttpSession session) {
        managerUserSession.logout(session);
        return "redirect:/login";
   }
}
