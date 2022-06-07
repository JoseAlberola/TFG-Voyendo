package voyendo.service;

import voyendo.authentication.ManagerUserSession;
import voyendo.controller.ModificarCompanyData;
import voyendo.controller.RegistroData;
import voyendo.model.Category;
import voyendo.model.CategoryRepository;
import voyendo.model.Company;
import voyendo.model.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompanyService {

    Logger logger = LoggerFactory.getLogger(CompanyService.class);

    private CompanyRepository companyRepository;

    private CategoryRepository categoryRepository;

    @Autowired
    ManagerUserSession managerUserSession;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, CategoryRepository categoryRepository) {
        this.companyRepository = companyRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public LoginStatus login(String username, String password) {
        Optional<Company> company = companyRepository.findByUsername(username);
        if (!company.isPresent()) {
            return LoginStatus.USER_NOT_FOUND;
        } else if (!managerUserSession.decryptPassword(password, company.get().getPassword())) {
            return LoginStatus.ERROR_PASSWORD;
        } else {
            return LoginStatus.LOGIN_OK;
        }
    }

    @Transactional(readOnly = true)
    public Company crearEmpresa(RegistroData registroData){
        logger.debug("Creando empresa " + registroData.getUsername());
        Category category = categoryRepository.findByName("Categoria").orElse(null);  // Default category
        if (category == null) {
            throw new CategoryServiceException("Categoría Default no existe al crear la empresa " + registroData.getUsername());
        }
        Company company = new Company(registroData.getUsername(), registroData.getName(), registroData.getMail(), category);
        company.setPhone(registroData.getPhone());
        company.setPassword(managerUserSession.encryptPassword(registroData.getPassword()));
        return company;
    }

    // Se añade un usuario en la aplicación.
    // El email y password del usuario deben ser distinto de null
    // El email no debe estar registrado en la base de datos
    @Transactional
    public Company registrar(Company company) {
        Optional<Company> companyBD = companyRepository.findByUsername(company.getUsername());
        if (companyBD.isPresent())
            throw new UsuarioServiceException("La empresa " + company.getUsername() + " ya está registrada");
        else if (company.getUsername() == null)
            throw new UsuarioServiceException("La empresa no tiene username");
        else if (company.getPassword() == null)
            throw new UsuarioServiceException("La empresa no tiene password");
        else return companyRepository.save(company);
    }

    @Transactional(readOnly = true)
    public Company findByUsername(String username) {
        return companyRepository.findByUsername(username).orElse(null);
    }

    @Transactional(readOnly = true)
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Company findById(Long usuarioId) {
        return companyRepository.findById(usuarioId).orElse(null);
    }

    @Transactional(readOnly = true)
    public Company findByMail(String mail) {
        return companyRepository.findByMail(mail).orElse(null);
    }

    @Transactional
    public Company modificarInfoBasica(Long idCompany, ModificarCompanyData modificarCompanyData) {
        logger.debug("Modificando empresa " + idCompany + " - " + modificarCompanyData.getName());
        Company company = companyRepository.findById(idCompany).orElse(null);
        if (company == null) {
            throw new CompanyServiceException("No existe empresa con id " + idCompany);
        }
        company.setName(modificarCompanyData.getName());
        company.setMail(modificarCompanyData.getMail());
        company.setPhone(modificarCompanyData.getPhone());
        company.setAddress(modificarCompanyData.getAddress());
        companyRepository.save(company);
        return company;
    }

    @Transactional
    public Company modificarPassword(Long idCompany, ModificarCompanyData modificarCompanyData) {
        logger.debug("Modificando contraseña de la empresa " + idCompany);
        Company company = companyRepository.findById(idCompany).orElse(null);
        if (company == null) {
            throw new CompanyServiceException("No existe empresa con id " + idCompany);
        }
        company.setPassword(modificarCompanyData.getNewPassword());
        companyRepository.save(company);
        return company;
    }

    @Transactional
    public Company modificarDetallesEmpresa(Long idCompany, ModificarCompanyData modificarCompanyData) {
        logger.debug("Modificando detalles de la empresa " + idCompany);
        Company company = companyRepository.findById(idCompany).orElse(null);
        if (company == null) {
            throw new CompanyServiceException("No existe empresa con id " + idCompany);
        }
        company.setStartday(modificarCompanyData.getStartday());
        company.setFinishday(modificarCompanyData.getFinishday());

        // Eliminamos la empresa de la lista de empresas de la antigua categoria
        Category categoriaAntigua = categoryRepository.findById(company.getCategory().getId()).orElse(null);
        categoriaAntigua.getCompanies().remove(company);
        categoryRepository.save(categoriaAntigua);

        // Añadimos la empresa a la lista de empresas de la nueva categoria
        Category categoriaNueva = categoryRepository.findById(modificarCompanyData.getCategory().getId()).orElse(null);
        company.setCategory(categoriaNueva);
        categoriaNueva.getCompanies().add(company);
        categoryRepository.save(categoriaNueva);
        companyRepository.save(company);
        return company;
    }
}
