package voyendo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.ModificarCompanyData;
import voyendo.controller.exception.CompanyNotFoundException;
import voyendo.model.Category;
import voyendo.model.Company;
import voyendo.model.Review;
import voyendo.service.CategoryService;
import voyendo.service.CompanyService;
import voyendo.service.ReviewService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class FileUploadController {

    public static String uploadDirectory = System.getProperty("user.home") + "/Voyendo/recursos-usuarios/";

    @Autowired
    CompanyService companyService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    ManagerUserSession managerUserSession;

    @PostMapping("/companies/{id}/image/{idImg}/upload")
    public String uploadImagenEmpresa(@PathVariable(value="id") Long idCompany, @PathVariable(value="idImg") int numberImg,
                                      Model model, HttpSession session, RedirectAttributes flash,
                                      @RequestParam("file") MultipartFile imagen){

        managerUserSession.comprobarUsuarioLogeado(session, idCompany);

        Company company = companyService.findById(idCompany);
        if (company == null) {
            throw new CompanyNotFoundException();
        }

        if(!imagen.isEmpty()){
            try {
                byte[] bytesImagen = imagen.getBytes();
                StringBuilder nuevoFileName = new StringBuilder();
                nuevoFileName.append(idCompany.toString());
                nuevoFileName.append("-");
                nuevoFileName.append(numberImg);
                nuevoFileName.append("-");
                nuevoFileName.append(imagen.getOriginalFilename());
                Path rutaCompleta = Paths.get(uploadDirectory + "//" + nuevoFileName.toString());
                Files.write(rutaCompleta, bytesImagen);
                companyService.actualizarImagen(idCompany, numberImg, nuevoFileName.toString());
            } catch (IOException e) {
                flash.addFlashAttribute("error", "No se ha podido actualizar la imagen.");
                e.printStackTrace();
            }
        }
        flash.addFlashAttribute("exito", "Imagen actualizada.");
        return "redirect:/companies/" + idCompany + "/cuenta";
    }
}