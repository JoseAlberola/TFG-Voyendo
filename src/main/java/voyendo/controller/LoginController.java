package voyendo.controller;

import voyendo.authentication.ManagerUserSession;
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
            return "redirect:/companies/" + company.getId() + "/home";
        }else if(loginCustomerStatus == LoginStatus.LOGIN_OK){
            Customer customer = customerService.findByUsername(loginData.getUsername());
            managerUserSession.logearUsuario(session, customer.getId());
            return "redirect:/home";
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
        model.addAttribute("registroData", new RegistroData());
        return "formRegistro2";
    }

   @PostMapping("/registro")
   public String registroSubmit(@Valid RegistroData registroData, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "formRegistro";
        }

        if (companyService.findByUsername(registroData.getUsername()) != null || customerService.findByUsername(registroData.getUsername()) != null) {
            model.addAttribute("registroData", registroData);
            model.addAttribute("error", "El usuario " + registroData.getUsername() + " ya existe");
            return "formRegistro";
        }

        if(registroData.getTipoRegistro().equals("empresa")){
            Company company = companyService.crearEmpresa(registroData);
            companyService.registrar(company);
        }else{
            Customer customer = customerService.crearCliente(registroData);
            customerService.registrar(customer);
        }

        return "redirect:/login";
   }

   @GetMapping("/logout")
   public String logout(HttpSession session) {
        managerUserSession.logout(session);
        return "redirect:/login";
   }
}
