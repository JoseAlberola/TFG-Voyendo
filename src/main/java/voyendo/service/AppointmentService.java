package voyendo.service;

import voyendo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    private CompanyRepository companyRepository;
    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(CompanyRepository companyRepository, AppointmentRepository appointmentRepository) {
        this.companyRepository = companyRepository;
        this.appointmentRepository = appointmentRepository;
    }

    /*
    @Transactional
    public Appointment nuevaCitaEmpresa(Long idCompany, Date date) {
        logger.debug("Añadiendo cita el día " + date + " a la empresa " + idCompany);
        Company company = companyRepository.findById(idCompany).orElse(null);
        if (company == null) {
            throw new TareaServiceException("Empresa " + idCompany + " no existe al crear cita el dia " + date);
        }
        Appointment appointment = new Appointment(date, company);
        appointmentRepository.save(appointment);
        return appointment;
    }
     */

    @Transactional(readOnly = true)
    public List<Appointment> allCitasEmpresa(Long idCompany) {
        logger.debug("Devolviendo todas las citas de la empresa " + idCompany);
        Company company = companyRepository.findById(idCompany).orElse(null);
        if (company == null) {
            throw new CompanyServiceException("Empresa " + idCompany + " no existe al listar citas ");
        }
        List<Appointment> citas = new ArrayList(company.getAppointments());
        Collections.sort(citas, (a, b) -> a.getId() < b.getId() ? -1 : a.getId() == b.getId() ? 0 : 1);
        return citas;
    }

    @Transactional(readOnly = true)
    public Appointment findById(Long appointmentId) {
        logger.debug("Buscando cita " + appointmentId);
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    @Transactional
    public Appointment modificaCita(Long idAppointment, Date date) {
        logger.debug("Modificando cita " + idAppointment + " - " + date);
        Appointment appointment = appointmentRepository.findById(idAppointment).orElse(null);
        if (appointment == null) {
            throw new CompanyServiceException("No existe cita con id " + idAppointment);
        }
        appointment.setDate(date);
        appointmentRepository.save(appointment);
        return appointment;
    }

    @Transactional
    public void borraCita(Long idAppointment) {
        logger.debug("Borrando cita " + idAppointment);
        Appointment appointment = appointmentRepository.findById(idAppointment).orElse(null);
        if (appointment == null) {
            throw new CompanyServiceException("No existe cita con id " + idAppointment);
        }
        appointmentRepository.delete(appointment);
    }
}
