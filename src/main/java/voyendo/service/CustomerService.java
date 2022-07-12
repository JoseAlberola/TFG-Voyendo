package voyendo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.ModificarCompanyData;
import voyendo.controller.Data.RegistroDataCustomer;
import voyendo.model.*;
import voyendo.service.exception.CompanyServiceException;
import voyendo.service.exception.CustomerServiceException;

import java.util.Optional;

@Service
public class CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private CustomerRepository customerRepository;

    @Autowired
    ManagerUserSession managerUserSession;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public LoginStatus login(String username, String password) {
        Optional<Customer> customer = customerRepository.findByUsername(username);
        if (!customer.isPresent()) {
            return LoginStatus.USER_NOT_FOUND;
        } else if (!managerUserSession.decryptPassword(password, customer.get().getPassword())) {
            return LoginStatus.ERROR_PASSWORD;
        } else {
            return LoginStatus.LOGIN_OK;
        }
    }

    @Transactional(readOnly = true)
    public Customer crearCliente(RegistroDataCustomer registroDataCustomer){
        logger.debug("Creando cliente " + registroDataCustomer.getUsername());
        Customer customer = new Customer(registroDataCustomer.getUsername(), registroDataCustomer.getName(), registroDataCustomer.getMail(),
                registroDataCustomer.getGender(), registroDataCustomer.getDateBirthday());
        customer.setPhone(registroDataCustomer.getPhone());
        customer.setPassword(managerUserSession.encryptPassword(registroDataCustomer.getPassword()));
        customer.setImg1("defaultAvatar.jpg");
        return customer;
    }

    // Se añade un usuario en la aplicación.
    // El email y password del usuario deben ser distinto de null
    // El email no debe estar registrado en la base de datos
    @Transactional
    public Customer registrar(Customer customer) {
        Optional<Customer> customerBD = customerRepository.findByUsername(customer.getUsername());
        if (customerBD.isPresent())
            throw new CustomerServiceException("El cliente " + customer.getUsername() + " ya está registrado");
        else if (customer.getUsername() == null)
            throw new CustomerServiceException("El cliente no tiene username");
        else if (customer.getPassword() == null)
            throw new CustomerServiceException("El cliente no tiene password");
        else return customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username).orElse(null);
    }

    @Transactional(readOnly = true)
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Customer findById(Long usuarioId) {
        return customerRepository.findById(usuarioId).orElse(null);
    }

    @Transactional
    public Customer modificarInfo(Long idCustomer, RegistroDataCustomer registroDataCustomer) {
        logger.debug("Modificando cliente " + idCustomer + " - " + registroDataCustomer.getName());
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        if (customer == null) {
            throw new CustomerServiceException("No existe cliente con id " + idCustomer);
        }
        customer.setMail(registroDataCustomer.getMail());
        customer.setName(registroDataCustomer.getName());
        customer.setPhone(registroDataCustomer.getPhone());
        customer.setBirthday(registroDataCustomer.getDateBirthday());
        customer.setGender(registroDataCustomer.getGender());
        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    public Customer modificarPassword(Long idCustomer, RegistroDataCustomer registroDataCustomer) {
        logger.debug("Modificando contraseña del cliente " + idCustomer);
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        if (customer == null) {
            throw new CustomerServiceException("No existe cliente con id " + idCustomer);
        }
        customer.setPassword(managerUserSession.encryptPassword(registroDataCustomer.getNewPassword()));
        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    public Customer actualizarImagen(Long idCustomer, String fileName) {
        logger.debug("Actualizando imagen del cliente " + idCustomer);
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        if (customer == null) {
            throw new CustomerServiceException("No existe cliente con id " + idCustomer);
        }

        customer.setImg1(fileName.toString());
        customerRepository.save(customer);
        return customer;
    }
}
