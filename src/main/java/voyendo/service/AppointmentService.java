package voyendo.service;

import org.apache.tomcat.jni.Local;
import voyendo.controller.Data.CrearAppointmentData;
import voyendo.controller.ReservaCalendario;
import voyendo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    private CompanyRepository companyRepository;
    private AppointmentRepository appointmentRepository;
    private CustomerRepository customerRepository;
    private LabourRepository labourRepository;

    @Autowired
    public AppointmentService(CompanyRepository companyRepository, AppointmentRepository appointmentRepository,
                              CustomerRepository customerRepository, LabourRepository labourRepository) {
        this.companyRepository = companyRepository;
        this.appointmentRepository = appointmentRepository;
        this.customerRepository = customerRepository;
        this.labourRepository = labourRepository;
    }

    @Transactional(readOnly = true)
    public Date convertToDate(String fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(fecha);
        } catch (ParseException e) {
            throw new DateFormatException("Excepción al convertir el string: " + fecha + " a Date.");
        }
    }

    @Transactional(readOnly = true)
    public Date convertToDateWithTime(String fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return sdf.parse(fecha);
        } catch (ParseException e) {
            throw new DateFormatException("Excepción al convertir el string: " + fecha + " a Date.");
        }
    }

    @Transactional(readOnly = true)
    public List<ReservaCalendario> convertirAppointmentsAReservasCalendario(List<Appointment> appointments){
        List <ReservaCalendario> resultado = new ArrayList<>();
        String username = "";
        for(Appointment appointment : appointments){
            Date start = convertToDateWithTime(appointment.getDate() + " " + appointment.getStarthour());
            Date end = convertToDateWithTime(appointment.getDate() + " " + appointment.getEndhour());
            if(appointment instanceof NormalAppointment){
                username = ((NormalAppointment) appointment).getCustomer().getUsername();
            }else if(appointment instanceof GuestAppointment){
                username = ((GuestAppointment) appointment).getName();
            }
            ReservaCalendario reservaCal = new ReservaCalendario(appointment.getId(), start, end,
                    appointment.getLabour().getName(), appointment.getStarthour(), appointment.getEndhour(), username);
            reservaCal.setIdlabour(appointment.getLabour().getId());
            resultado.add(reservaCal);
        }
        return resultado;
    }

    @Transactional(readOnly = true)
    public Appointment crearReserva(Date fecha, Company company, Labour labour, CrearAppointmentData crearAppointmentData){
        Customer customer = customerRepository.findByUsername(crearAppointmentData.getUsername()).orElse(null);
        if(customer == null){  // Es un invitado
            String nombreCliente = crearAppointmentData.getUsername();
            return new GuestAppointment(fecha, company, labour, nombreCliente);
        }else{  // Es un cliente registrado
            return new NormalAppointment(fecha, company, labour, customer);
        }
    }

    @Transactional(readOnly = true)
    public boolean citaDentroDelHorario(Company company, Appointment appointment){
        LocalTime horaInicioCita = LocalTime.parse(appointment.getStarthour());
        LocalTime horaFinCita = horaInicioCita.plusMinutes(appointment.getLabour().getDuration());

        LocalTime horaApertura = LocalTime.parse(company.getStartday());
        LocalTime horaCierre = LocalTime.parse(company.getFinishday());

        if((horaInicioCita.isAfter(horaApertura) || horaInicioCita.equals(horaApertura)) &&
            horaFinCita.isBefore(horaCierre) || horaFinCita.equals(horaCierre)){
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public boolean huecoDisponible(Appointment appointment){
        LocalTime horaInicioNuevaCita = LocalTime.parse(appointment.getStarthour());
        LocalTime horaFinNuevaCita = horaInicioNuevaCita.plusMinutes(appointment.getLabour().getDuration());

        List<Appointment> citasMismoDia = appointmentRepository.todasLasReservasDelDia(appointment.getCompany().getId(),
                appointment.getDate());
        for(Appointment cita : citasMismoDia){
            if(cita.getId() != appointment.getId()) {
                LocalTime horaInicioCita = LocalTime.parse(cita.getStarthour());
                LocalTime horaFinCita = LocalTime.parse(cita.getEndhour());
                if ((horaInicioNuevaCita.isBefore(horaInicioCita) || horaInicioNuevaCita.equals(horaInicioCita)) &&
                        horaFinNuevaCita.isAfter(horaInicioCita)) {
                    return false;
                } else if ((horaInicioNuevaCita.isAfter(horaInicioCita) || horaInicioNuevaCita.equals(horaInicioCita)) &&
                        (horaFinNuevaCita.isBefore(horaFinCita)) || horaFinNuevaCita.equals(horaFinCita)) {
                    return false;
                } else if (horaInicioNuevaCita.isBefore(horaFinCita) && horaFinNuevaCita.isAfter(horaFinCita)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Transactional(readOnly = true)
    public boolean comprobarHorasCita(Appointment appointment){
        if(citaDentroDelHorario(appointment.getCompany(), appointment)){
            return huecoDisponible(appointment);
        }else{
            return false; // Error. La cita está fuera del horario de la empresa
        }
    }

    @Transactional
    public boolean nuevaReserva(Company company, CrearAppointmentData crearAppointmentData) {
        logger.debug("Creando reserva para la empresa " + company.getId());
        Date fechaCita = convertToDate(crearAppointmentData.getStart());
        Labour labour = labourRepository.findById(crearAppointmentData.getIdlabour()).orElse(null);
        if(labour == null){
            throw new LabourServiceException("No existe labour con id: " + crearAppointmentData.getIdlabour());
        }
        Appointment appointment = crearReserva(fechaCita, company, labour, crearAppointmentData);
        appointment.setStarthour(crearAppointmentData.getStarthour());
        LocalTime horaInicio = LocalTime.parse(crearAppointmentData.getStarthour());
        LocalTime horaFin = horaInicio.plusMinutes(labour.getDuration());
        appointment.setEndhour(horaFin.toString());
        if(comprobarHorasCita(appointment)){
            appointmentRepository.save(appointment);
            return true;
        }else{
            return false;
        }
    }

    @Transactional(readOnly = true)
    public Appointment findById(Long appointmentId) {
        logger.debug("Buscando cita " + appointmentId);
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    @Transactional
    public boolean modificarCita(Company company, CrearAppointmentData crearAppointmentData) {
        Long idAppointment = crearAppointmentData.getIdappointment();
        logger.debug("Modificando cita " + idAppointment + " - " + crearAppointmentData.getStart());

        Appointment citaAntigua = appointmentRepository.findById(idAppointment).orElse(null);
        if (citaAntigua == null) {
            throw new AppointmentServiceException("No existe cita con id " + idAppointment);
        }

        Date fechaCita = convertToDate(crearAppointmentData.getStart());
        Labour labour = labourRepository.findById(crearAppointmentData.getIdlabour()).orElse(null);
        if(labour == null){
            throw new LabourServiceException("No existe labour con id: " + crearAppointmentData.getIdlabour());
        }
        Appointment citaNueva = crearReserva(fechaCita, company, labour, crearAppointmentData);
        citaNueva.setId(idAppointment);
        citaNueva.setStarthour(crearAppointmentData.getStarthour());
        LocalTime horaInicio = LocalTime.parse(crearAppointmentData.getStarthour());
        LocalTime horaFin = horaInicio.plusMinutes(labour.getDuration());
        citaNueva.setEndhour(horaFin.toString());
        if(comprobarHorasCita(citaNueva)){
            if(citaAntigua.getClass() != citaNueva.getClass()){
                appointmentRepository.delete(citaAntigua);
            }
            appointmentRepository.save(citaNueva);
            return true;
        }

        return false;
    }

    @Transactional
    public void eliminarReserva(Long idAppointment) {
        logger.debug("Eliminando reserva " + idAppointment);
        Appointment appointment = appointmentRepository.findById(idAppointment).orElse(null);
        if (appointment == null) {
            throw new AppointmentServiceException("No existe reserva con id " + idAppointment);
        }
        appointmentRepository.delete(appointment);
    }

    @Transactional
    public boolean moverReserva(Long idAppointment, String nuevaFecha, String nuevaHoraInicio, String nuevaHoraFin) {
        logger.debug("Moviendo reserva " + idAppointment);

        Appointment appointment = appointmentRepository.findById(idAppointment).orElse(null);
        if (appointment == null) {
            throw new AppointmentServiceException("No existe reserva con id " + idAppointment);
        }

        Date fechaReserva = convertToDate(nuevaFecha);
        Appointment copiaAppointment = new Appointment();
        if(appointment instanceof GuestAppointment){
            copiaAppointment = new GuestAppointment(fechaReserva, appointment.getCompany(), appointment.getLabour(), ((GuestAppointment) appointment).getName());
        }else if(appointment instanceof NormalAppointment){
            copiaAppointment = new NormalAppointment(fechaReserva, appointment.getCompany(), appointment.getLabour(), ((NormalAppointment) appointment).getCustomer());
        }
        copiaAppointment.setId(appointment.getId());
        copiaAppointment.setStarthour(nuevaHoraInicio);
        copiaAppointment.setEndhour(nuevaHoraFin);

        if(comprobarHorasCita(copiaAppointment)){
            appointment.setDate(fechaReserva);
            appointment.setStarthour(nuevaHoraInicio);
            appointment.setEndhour(nuevaHoraFin);
            appointmentRepository.save(appointment);
            return true;
        }
        return false;
    }
}
