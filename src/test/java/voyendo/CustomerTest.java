package voyendo;

import voyendo.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    public void crearCliente() {
        Customer customer = new Customer("jose", "Jose Alberola", "jose@ua.com", "male", new Date());
        assertThat(customer.getName()).isEqualTo("Jose Alberola");
    }

    @Test
    @Transactional
    public void grabarCliente() {
        Customer customer = new Customer("jose", "Jose Alberola", "jose@ua.com", "male", new Date());

        customerRepository.save(customer);

        assertThat(customer.getId()).isNotNull();
    }

    @Test
    public void comprobarIgualdadClientes() {
        // Creamos tres clientes sin id, sólo con el nombre
        Customer customer1 = new Customer("josele", "Jose Alberola", "jose@ua.com", "male", new Date());
        Customer customer2 = new Customer("jose", "Jose Alberola", "jose@ua.com", "male", new Date());
        Customer customer3 = new Customer("jose", "Jose Alberola", "jose@ua.com", "male", new Date());

        // Comprobamos igualdad basada en el atributo username
        assertThat(customer1).isNotEqualTo(customer2);
        assertThat(customer2).isEqualTo(customer3);

        // Añadimos identificadores y comprobamos igualdad por identificadores
        customer1.setId(1L);
        customer2.setId(1L);
        customer3.setId(2L);

        // Comprobamos igualdad basada en el atributo ID
        assertThat(customer1).isEqualTo(customer2);
        assertThat(customer2).isNotEqualTo(customer3);
    }

    @Test
    public void comprobarRecuperarCliente() {
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        Customer customer = customerRepository.findById(1L).orElse(null);

        // THEN
        assertThat(customer).isNotNull();
        assertThat(customer.getId()).isEqualTo(1L);
        assertThat(customer.getName()).isEqualTo("Cliente1");
    }

    @Test
    @Transactional
    public void comprobarRelacionBaseDatos() {
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        Customer customer = customerRepository.findById(1L).orElse(null);
        NormalAppointment appointment = (NormalAppointment) appointmentRepository.findById(1L).orElse(null);

        assertThat(customer.getAppointments()).hasSize(1);
        assertThat(customer.getAppointments()).contains(appointment);
        assertThat(appointment.getCustomer()).isEqualTo(customer);
    }

    @Test
    public void comprobarFindAll() {
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        Iterable<Customer> customers = customerRepository.findAll();

        assertThat(customers).hasSize(3);
    }

    @Test
    @Transactional
    public void actualizarRelacionCustomerAppointment() {
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        NormalAppointment appointment = (NormalAppointment) appointmentRepository.findById(2L).orElse(null);
        Customer customer = customerRepository.findById(1L).orElse(null);

        appointment.setCustomer(customer);
        customer.getAppointments().add(appointment);

        assertThat(customer.getAppointments()).contains(appointment);
        assertThat(appointment.getCustomer()).isEqualTo(customer);
    }

}
