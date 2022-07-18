package voyendo;


import voyendo.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CompanyTest {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    LabourRepository labourRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Test
    public void crearCompany() throws Exception {
        Category category = new Category("nueva");
        Company company = new Company("jose", "Jose Alberola", "jose@ua.com", "Aspe, España", category);

        assertThat(company.getName()).isEqualTo("Jose Alberola");
        assertThat(company.getCategory()).isEqualTo(category);
    }


    @Test
    public void comprobarIgualdadSinId() {
        Category category = new Category("nueva");

        Company company1 = new Company("jose", "Jose Alberola", "jose@ua.com", "Aspe, España", category);
        Company company2 = new Company("jose", "Jose Alberola", "jose@ua.com", "Aspe, España", category);
        Company company3 = new Company("josele", "Jose Alberola", "jose@ua.com", "Aspe, España", category);

        assertThat(company1).isEqualTo(company2);
        assertThat(company1).isNotEqualTo(company3);
    }

    @Test
    public void comprobarIgualdadConId() {
        Category category = new Category("nueva");

        Company company1 = new Company("jose", "Jose Alberola", "jose@ua.com", "Aspe, España", category);
        Company company2 = new Company("jose", "Jose Alberola", "jose@ua.com", "Aspe, España", category);
        Company company3 = new Company("josele", "Jose Alberola", "jose@ua.com", "Aspe, España", category);

        company1.setId(1L);
        company2.setId(2L);
        company3.setId(1L);

        assertThat(company1).isEqualTo(company3);
        assertThat(company1).isNotEqualTo(company2);
    }

    //
    // Tests CompanyRepository
    //

    @Test
    @Transactional
    public void crearCompanyEnBaseDatos() {
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        Category category = categoryRepository.findById(2L).orElse(null);
        Company company = new Company("jose", "Jose Alberola", "jose@ua.com", "Aspe, España", category);

        companyRepository.save(company);

        assertThat(company.getId()).isNotNull();
        assertThat(company.getCategory()).isEqualTo(category);
        assertThat(company.getName()).isEqualTo("Jose Alberola");
    }

    @Test
    @Transactional
    public void salvarCompanyEnBaseDatosConCategoryNoBDLanzaExcepcion() {
        // Creamos una empresa sin ID y, por tanto, sin estar en gestionado
        // por JPA
        Category category = new Category("nueva");
        Company company = new Company("jose", "Jose Alberola", "jose@ua.com", "Aspe, España", category);

        // Se lanza una excepción al intentar salvar una empresa sin ID
        Assertions.assertThrows(Exception.class, () -> {
            companyRepository.save(company);
        });
    }

    @Test
    @Transactional(readOnly = true)
    public void unaEmpresaTieneReservas() {
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        Company company = companyRepository.findById(1L).orElse(null);

        Set<Appointment> reservas = company.getAppointments();

        assertThat(reservas).isNotEmpty();
    }

    @Test
    @Transactional
    public void unaReservaNuevaSeAñadeALaListaDeReservas() {
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        Labour labour = labourRepository.findById(1L).orElse(null);
        Company company = companyRepository.findById(1L).orElse(null);

        Set<Appointment> reservas = company.getAppointments();
        Appointment reserva = new Appointment(new Date(), company, labour);
        appointmentRepository.save(reserva);

        assertThat(company.getAppointments()).contains(reserva);
        assertThat(reservas).isEqualTo(company.getAppointments());
        assertThat(company.getAppointments()).contains(reserva);
    }

}
