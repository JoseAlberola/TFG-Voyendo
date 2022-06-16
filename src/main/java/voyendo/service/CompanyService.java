package voyendo.service;

import org.apache.tomcat.jni.Local;
import org.springframework.core.env.Environment;
import voyendo.Application;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.graficos.HistoricoNuevosClientesGrafico;
import voyendo.controller.graficos.HistoricoReservasGrafico;
import voyendo.controller.ModificarCompanyData;
import voyendo.controller.RegistroDataCompany;
import voyendo.controller.graficos.TraceHistoricoGrafico;
import voyendo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
public class CompanyService {

    Logger logger = LoggerFactory.getLogger(CompanyService.class);

    private CompanyRepository companyRepository;

    private CategoryRepository categoryRepository;

    private AppointmentRepository appointmentRepository;

    @Autowired
    ManagerUserSession managerUserSession;

    @Autowired
    private Environment env;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, CategoryRepository categoryRepository, AppointmentRepository appointmentRepository) {
        this.companyRepository = companyRepository;
        this.categoryRepository = categoryRepository;
        this.appointmentRepository = appointmentRepository;
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
    public Company crearEmpresa(RegistroDataCompany registroDataCompany){
        logger.debug("Creando empresa " + registroDataCompany.getUsername());
        Category category = categoryRepository.findByName("Categoria").orElse(null);  // Default category
        if (category == null) {
            throw new CategoryServiceException("Categoría Default no existe al crear la empresa " + registroDataCompany.getUsername());
        }
        Company company = new Company(registroDataCompany.getUsername(), registroDataCompany.getName(), registroDataCompany.getMail(),
                registroDataCompany.getAddress(), category);
        company.setPhone(registroDataCompany.getPhone());
        company.setPassword(managerUserSession.encryptPassword(registroDataCompany.getPassword()));
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

    public double calcularPorcentaje(double valorNuevo, double valorAnterior){
        if(valorNuevo == 0.0){
            return valorAnterior * -100.0;
        }
        if(valorAnterior == 0.0){
            return valorNuevo * 100;
        }
        return (valorNuevo / valorAnterior) * 100.0 - 100.0;
    }

    public String colorPorcentaje(double porcentaje){
        if(porcentaje < 0){
            return "red";
        }else{
            return "green";
        }
    }

    @Transactional(readOnly = true)
    public StatisticsCard obtenerCartaReservasTotales(Company company){
        double totalReservasEsteMes = appointmentRepository.totalAppointmentsThisMonth(company.getId());
        double totalReservasMesPasado = appointmentRepository.totalAppointmentsLastMonth(company.getId());

        double porcentaje = calcularPorcentaje(totalReservasEsteMes, totalReservasMesPasado);
        return new StatisticsCard(totalReservasEsteMes, Math.abs(porcentaje), colorPorcentaje(porcentaje));
    }

    @Transactional(readOnly = true)
    public StatisticsCard obtenerCartaIngresosTotales(Company company){
        double totalIngresosEsteMes = appointmentRepository.totalRevenueThisMonth(company.getId());
        double totalIngresosMesPasado = appointmentRepository.totalRevenueLastMonth(company.getId());

        double porcentaje = calcularPorcentaje(totalIngresosEsteMes, totalIngresosMesPasado);
        return new StatisticsCard(totalIngresosEsteMes, Math.abs(porcentaje), colorPorcentaje(porcentaje));
    }

    @Transactional(readOnly = true)
    public StatisticsCard obtenerCartaClientesTotales(Company company){
        double totalClientesEsteMes = appointmentRepository.totalCustomersThisMonth(company.getId());
        double totalClientesMesPasado = appointmentRepository.totalCustomersLastMonth(company.getId());

        double porcentaje = calcularPorcentaje(totalClientesEsteMes, totalClientesMesPasado);
        return new StatisticsCard(totalClientesEsteMes, Math.abs(porcentaje), colorPorcentaje(porcentaje));
    }

    @Transactional(readOnly = true)
    public StatisticsCard obtenerCartaNuevosClientes(Company company){
        double totalNuevosClientesEsteMes = appointmentRepository.totalNewCustomersThisMonth(company.getId());
        double totalNuevosClientesMesPasado = appointmentRepository.totalNewCustomersLastMonth(company.getId());

        double porcentaje = calcularPorcentaje(totalNuevosClientesEsteMes, totalNuevosClientesMesPasado);
        return new StatisticsCard(totalNuevosClientesEsteMes, Math.abs(porcentaje), colorPorcentaje(porcentaje));
    }

    @Transactional(readOnly = true)
    public ArrayList<StatisticsCard> obtenerCartasEstadisticas(Company company){
        ArrayList<StatisticsCard> cartas = new ArrayList<>();
        cartas.add(obtenerCartaReservasTotales(company));
        cartas.add(obtenerCartaIngresosTotales(company));
        cartas.add(obtenerCartaClientesTotales(company));
        cartas.add(obtenerCartaNuevosClientes(company));
        return cartas;
    }

    @Transactional(readOnly = true)
    public int[] obtenerNumeroClientesPorGenero(Company company){
        int contadorHombres = 0;
        int contadorMujeres = 0;
        for(Appointment reserva : company.getAppointments()){
            if(reserva.getCustomer().getGender().equals("male")){
                contadorHombres++;
            }else {
                contadorMujeres++;
            }
        }
        return new int[] {contadorHombres, contadorMujeres};
    }

    /*
        1. Entre 0 y 25
        2. Entre 26 y 45
        3. Entre 46 y 65
        4. Mayores que 65
     */
    @Transactional(readOnly = true)
    public int[] obtenerNumeroClientesPorEdad(Company company){

        int totalRango1 = appointmentRepository.clientesMenores25(company.getId());
        int totalRango2 = appointmentRepository.clientesEntre26y45(company.getId());
        int totalRango3 = appointmentRepository.clientesEntre46y65(company.getId());
        int totalRango4 = appointmentRepository.clientesMayores65(company.getId());

        return new int[] {totalRango1, totalRango2, totalRango3, totalRango4};
    }

    @Transactional(readOnly = true)
    public ArrayList<String> obtenerServicios(Company company){
        ArrayList<String> resultado = new ArrayList<>();
        for(Labour servicio : company.getLabours()){
            resultado.add(servicio.getName());
        }
        return resultado;
    }

    @Transactional(readOnly = true)
    public ArrayList<Integer> obtenerTotalReservasPorServicio(Company company){
        ArrayList<Integer> resultado = new ArrayList<>();
        for(Labour servicio : company.getLabours()){
            resultado.add(appointmentRepository.totalReservasPorServicio(company.getId(), servicio.getId()));
        }
        return resultado;
    }

    @Transactional(readOnly = true)
    public ArrayList<Date> procesarFechas(List<Date> todasLasFechas){
        ArrayList<Date> resultado = new ArrayList<>();
        SortedSet<Date> fechas = new TreeSet<>();
        for(Date fecha : todasLasFechas){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            LocalDate primeroMes;
            if(calendar.get(Calendar.MONTH) == 11){
                primeroMes = LocalDate.of(calendar.get(Calendar.YEAR)+1, 1,
                        calendar.get(Calendar.DAY_OF_MONTH)).with(TemporalAdjusters.firstDayOfMonth());
            }else{
                primeroMes = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+2,
                        calendar.get(Calendar.DAY_OF_MONTH)).with(TemporalAdjusters.firstDayOfMonth());
            }
            fechas.add(java.sql.Date.valueOf(primeroMes));
        }
        resultado.addAll(fechas);
        return resultado;
    }

    @Transactional(readOnly = true)
    public HistoricoReservasGrafico obtenerHistoricoReservas(Company company){
        ArrayList<TraceHistoricoGrafico> traces = new ArrayList<>();
        for(Labour servicio : company.getLabours()){
            ArrayList<Date> fechas = procesarFechas(appointmentRepository.fechasReservasPorServicio(company.getId(), servicio.getId()));
            ArrayList<Integer> valores = new ArrayList<>(appointmentRepository.reservasPorServicioMes(company.getId(), servicio.getId()));
            TraceHistoricoGrafico trace = new TraceHistoricoGrafico(servicio.getName(), fechas, valores);
            traces.add(trace);
        }
        Date fechaInicioRango = appointmentRepository.fechaPrimeraReserva(company.getId());
        Date fechaFinRango = appointmentRepository.fechaUltimaReserva(company.getId());
        HistoricoReservasGrafico grafico = new HistoricoReservasGrafico(traces, fechaInicioRango, fechaFinRango);
        return grafico;
    }

    @Transactional(readOnly = true)
    public ArrayList<Integer> numeroNuevosClientesIncrementalH2(Long idCompany, ArrayList<Date> fechas){
        ArrayList<Integer> resultado = new ArrayList<>();
        int valor = 0;
        for(Date fecha : fechas){
            valor += appointmentRepository.totalNewCustomersOnMonthH2(idCompany, fecha.toString());
            resultado.add(valor);
        }
        return resultado;
    }

    @Transactional(readOnly = true)
    public ArrayList<Integer> numeroNuevosClientesIncrementalMySQL(Long idCompany, ArrayList<Date> fechas){
        ArrayList<Integer> resultado = new ArrayList<>();
        int valor = 0;
        for(Date fecha : fechas){
            valor += appointmentRepository.totalNewCustomersOnMonthMySQL(idCompany, fecha.toString());
            resultado.add(valor);
        }
        return resultado;
    }

    @Transactional(readOnly = true)
    public HistoricoNuevosClientesGrafico obtenerHistoricoNuevosClientes(Company company){
        Date fechaInicioRango = appointmentRepository.fechaPrimeraReserva(company.getId());
        Date fechaFinRango = appointmentRepository.fechaUltimaReserva(company.getId());
        ArrayList<Date> fechas = procesarFechas(appointmentRepository.fechasTodasLasReservas(company.getId()));
        ArrayList<Integer> valores;
        if(env.getActiveProfiles().length == 0){  // No hay perfil activado. Estamos ejecutando H2-CONSOLE
            valores = numeroNuevosClientesIncrementalH2(company.getId(), fechas);
        }else{  // Ejecutamos MySQL
            valores = numeroNuevosClientesIncrementalMySQL(company.getId(), fechas);
        }
        TraceHistoricoGrafico trace = new TraceHistoricoGrafico("Nuevos clientes", fechas, valores);
        HistoricoNuevosClientesGrafico grafico = new HistoricoNuevosClientesGrafico(trace, fechaInicioRango, fechaFinRango);
        return grafico;
    }

    @Transactional
    public Company premium(Long idCompany, boolean premium) {
        Company company = companyRepository.findById(idCompany).orElse(null);
        if (company == null) {
            throw new CompanyServiceException("No existe empresa con id " + idCompany);
        }
        company.setPremium(premium);
        companyRepository.save(company);
        return company;
    }

}
