package voyendo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.Data.RegistroDataCustomer;
import voyendo.model.*;

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
        } else if (!customer.get().getPassword().equals(password)) {
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
        return customer;
    }

    // Se añade un usuario en la aplicación.
    // El email y password del usuario deben ser distinto de null
    // El email no debe estar registrado en la base de datos
    @Transactional
    public Customer registrar(Customer customer) {
        Optional<Customer> customerBD = customerRepository.findByUsername(customer.getUsername());
        if (customerBD.isPresent())
            throw new UsuarioServiceException("El cliente " + customer.getUsername() + " ya está registrado");
        else if (customer.getUsername() == null)
            throw new UsuarioServiceException("El cliente no tiene username");
        else if (customer.getPassword() == null)
            throw new UsuarioServiceException("El cliente no tiene password");
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

    @Transactional(readOnly = true)
    public Customer findByMail(String mail) {
        return customerRepository.findByMail(mail).orElse(null);
    }
}
