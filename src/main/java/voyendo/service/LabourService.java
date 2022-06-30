package voyendo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voyendo.controller.Data.CrearAppointmentData;
import voyendo.controller.Data.LabourData;
import voyendo.model.*;

import java.time.LocalTime;
import java.util.Date;

@Service
public class LabourService {

    Logger logger = LoggerFactory.getLogger(LabourService.class);

    private CompanyRepository companyRepository;
    private LabourRepository labourRepository;

    @Autowired
    public LabourService(CompanyRepository companyRepository, LabourRepository labourRepository) {
        this.companyRepository = companyRepository;
        this.labourRepository = labourRepository;
    }

    @Transactional(readOnly = true)
    public Labour findById(Long idLabour) {
        logger.debug("Buscando cita " + idLabour);
        return labourRepository.findById(idLabour).orElse(null);
    }

    @Transactional
    public boolean crearServicio(Company company, LabourData labourData) {
        logger.debug("Creando servicio para la empresa " + company.getId());
        if(labourRepository.numeroServiciosActivados(company.getId()) >= 5){  // solo se puede tener 5 servicios activados
            return false;
        }else{
            Labour labour = new Labour(labourData.getName(), labourData.getDuration(), labourData.getPrice(), true, company);
            labourRepository.save(labour);
            return true;
        }
    }

    @Transactional
    public boolean modificarServicio(Company company, LabourData labourData) {
        Long idLabour = labourData.getIdlabour();
        logger.debug("Modificando servicio " + labourData.getIdlabour() + " de la empresa " + company.getId());

        Labour labour = labourRepository.findById(idLabour).orElse(null);
        if (labour == null) {
            throw new LabourServiceException("No existe servicio con id " + idLabour);
        }

        if(company.equals(labour.getCompany())){
            labour.setActivated(false);  // El servicio editado pasa a inactivo
            labourRepository.save(labour);

            Labour nuevoLabour = new Labour(labourData.getName(), labourData.getDuration(), labourData.getPrice(), true, company);
            labourRepository.save(nuevoLabour);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean eliminarServicio(Long idLabour) {
        logger.debug("Eliminando servicio " + idLabour);
        Labour labour = labourRepository.findById(idLabour).orElse(null);
        if (labour == null) {
            throw new LabourServiceException("No existe servicio con id " + idLabour);
        }
        if(!labour.isActivated()){
            return false;
        }else{
            labour.setActivated(false);
            labourRepository.save(labour);
            return true;
        }
    }

}
