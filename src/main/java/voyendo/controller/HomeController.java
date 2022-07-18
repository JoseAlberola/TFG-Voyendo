package voyendo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.BuscadorData;
import voyendo.controller.Data.ModificarCompanyData;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.controller.exception.CustomerNotFoundException;
import voyendo.model.*;
import voyendo.service.CategoryService;
import voyendo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import voyendo.service.CustomerService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void paginacion(Model model, Optional<Integer> page, Optional<Integer> size, List<Company> listaEmpresas) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(8);

        Page<Company> listPage = companyService.paginar(PageRequest.of(currentPage - 1, pageSize), listaEmpresas);

        model.addAttribute("listPage", listPage);

        int totalPages = listPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("paginaActual", currentPage);
        }
    }

    private String getDatosHome(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, Customer customer, List<Company> listaEmpresas) {
        paginacion(model, page, size, listaEmpresas);

        Iterable<Category> categorias = categoryService.findAll();
        model.addAttribute("customer", customer);
        model.addAttribute("categorias", categorias);
        model.addAttribute("companies", listaEmpresas);
        return "home";
    }

    @GetMapping("/clientes/{id}/home")
    public String home(@PathVariable(value="id") Long idCustomer, Model model, HttpSession session,
                       @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                       @ModelAttribute BuscadorData buscadorData) {

        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);

        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        List<Company> listaEmpresas = new ArrayList<Company>();
        companyService.findAll().forEach(listaEmpresas::add);
        return getDatosHome(model, page, size, customer, listaEmpresas);
    }

    @RequestMapping(value = "/clientes/{id}/home/listadoEmpresas", method = RequestMethod.GET)
    public String listadoEmpresas(@PathVariable(value="id") Long idCustomer, Model model, HttpSession session,
                                @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                                @ModelAttribute BuscadorData buscadorData) {

        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);

        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        List<Company> listaEmpresas = new ArrayList<Company>();
        companyService.findAll().forEach(listaEmpresas::add);
        return getDatosHome(model, page, size, customer, listaEmpresas);
    }

    private int obtenerValorDistanciaLimite(int opcionRadio){
        if(opcionRadio == 0){
            return 15000;
        }else if(opcionRadio == 1){
            return 30000;
        }else if(opcionRadio == 2){
            return 50000;
        }else {
            return -1;
        }
    }

    @PostMapping("/clientes/{id}/home/buscar")
    public String buscador(@PathVariable(value="id") Long idCustomer, Model model, HttpSession session,
                           @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                           @ModelAttribute BuscadorData buscadorData) {

        managerUserSession.comprobarUsuarioLogeado(session, idCustomer);

        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        String categoria = buscadorData.getCategoria();
        String servicio = buscadorData.getServicio();
        String ubicacion = buscadorData.getUbicacion();
        String fecha = buscadorData.getFecha();
        int distanciaLimite = obtenerValorDistanciaLimite(buscadorData.getDistancia());
        List<Company> listaEmpresas = companyService.criteriosBuscador(categoria, servicio, ubicacion, fecha, distanciaLimite);
        return getDatosHome(model, page, size, customer, listaEmpresas);
    }

}
