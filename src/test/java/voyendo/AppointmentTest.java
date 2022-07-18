package voyendo;

import voyendo.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private LabourRepository labourRepository;

    @Test
    public void crearReserva() throws Exception {
        Category category = new Category("nueva");
        Company company = new Company("jose", "Jose Alberola", "jose@ua.com", "Aspe, España", category);
        Labour labour = new Labour("Corte de pelo", 30, 12, true, company);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Appointment appointment = new Appointment(sdf.parse("2022-07-20"), company, labour);

        assertThat(appointment.getCompany()).isEqualTo(company);
        assertThat(appointment.getDate()).isEqualTo(sdf.parse("2022-07-20"));
        assertThat(appointment.getLabour()).isEqualTo(labour);
    }

    @Test
    @Transactional
    public void crearAppointmentBaseDatos() throws Exception {
        Company company = companyRepository.findById(1L).orElse(null);
        Labour labour = labourRepository.findById(1L).orElse(null);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Appointment appointment = new Appointment(sdf.parse("2022-07-20"), company, labour);
        appointment.setStarthour("09:00");
        appointment.setEndhour("09:30");

        appointmentRepository.save(appointment);

        assertThat(appointment.getId()).isNotNull();
        assertThat(appointment.getCompany()).isEqualTo(company);
        assertThat(appointment.getLabour()).isEqualTo(labour);
        assertThat(appointment.getStarthour()).isEqualTo("09:00");
        assertThat(appointment.getEndhour()).isEqualTo("09:30");
        assertThat(appointment.getDate()).isEqualTo(sdf.parse("2022-07-20"));
    }

    @Test
    @Transactional(readOnly = true)
    public void buscarAppointmentEnBaseDatos() throws Exception {
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        Company company = companyRepository.findById(1L).orElse(null);
        Appointment appointment = appointmentRepository.findById(1L).orElse(null);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        assertThat(appointment).isNotNull();
        assertThat(appointment.getId()).isEqualTo(1L);
        assertThat(appointment.getCompany()).isEqualTo(company);
        assertThat(appointment.getDate()).isEqualTo(sdf.parse("2022-07-21"));
    }
}