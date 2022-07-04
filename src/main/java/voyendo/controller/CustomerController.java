package voyendo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.exception.CustomerNotFoundException;
import voyendo.model.Company;
import voyendo.service.CompanyService;

import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {

    @Autowired
    CompanyService companyService;

    @Autowired
    ManagerUserSession managerUserSession;

    @GetMapping("/usuarios")
    public String listarEmpresas(Model model, HttpSession session) {

        Iterable<Company> companies = companyService.findAll();
        Long idCompany = managerUserSession.usuarioLogeado(session);
        if(idCompany == null){
            model.addAttribute("usuario", null);
        }else{
            Company company = companyService.findById(idCompany);
            model.addAttribute("usuario", company);
        }

        model.addAttribute("usuarios", companies);
        return "estadisticas";
    }

    @GetMapping("/usuarios/{id}")
    public String detallesEmpresa(@PathVariable(value="id") Long idEmpresaConsultada, Model model, HttpSession session) {

        Company companyConsultada = companyService.findById(idEmpresaConsultada);
        if (companyConsultada == null) {
            throw new CustomerNotFoundException();
        }
        model.addAttribute("usuarioConsultado", companyConsultada);

        Long idCompanyLogeado = managerUserSession.usuarioLogeado(session);
        if(idCompanyLogeado == null){
            model.addAttribute("usuarioLogeado", null);
        }else{
            Company companyLogeado = companyService.findById(idCompanyLogeado);
            model.addAttribute("usuarioLogeado", companyLogeado);
        }

        return "descripcionUsuario";
    }
}
