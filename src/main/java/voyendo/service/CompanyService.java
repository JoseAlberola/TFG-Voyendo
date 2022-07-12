package voyendo.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import voyendo.authentication.ManagerUserSession;
import voyendo.controller.graficos.HistoricoNuevosClientesGrafico;
import voyendo.controller.graficos.HistoricoReservasGrafico;
import voyendo.controller.Data.ModificarCompanyData;
import voyendo.controller.Data.RegistroDataCompany;
import voyendo.controller.graficos.TraceHistoricoGrafico;
import voyendo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voyendo.service.exception.CategoryServiceException;
import voyendo.service.exception.CompanyServiceException;
import voyendo.service.exception.DateFormatException;
import voyendo.service.exception.CustomerServiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
public class CompanyService {

    Logger logger = LoggerFactory.getLogger(CompanyService.class);

    private CompanyRepository companyRepository;

    private CategoryRepository categoryRepository;

    private AppointmentRepository appointmentRepository;

    private LabourRepository labourRepository;

    private ReviewRepository reviewRepository;

    @Autowired
    ManagerUserSession managerUserSession;

    @Autowired
    private Environment env;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, CategoryRepository categoryRepository,
                          AppointmentRepository appointmentRepository, LabourRepository labourRepository,
                          ReviewRepository reviewRepository) {
        this.companyRepository = companyRepository;
        this.categoryRepository = categoryRepository;
        this.appointmentRepository = appointmentRepository;
        this.labourRepository = labourRepository;
        this.reviewRepository = reviewRepository;
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
        company.setImg1("defaultAvatar.jpg");
        company.setImg2("defaultAvatar.jpg");
        company.setImg3("defaultAvatar.jpg");
        company.setImg4("defaultAvatar.jpg");
        company.setImg5("defaultAvatar.jpg");
        return company;
    }

    // Se añade una empresa en la aplicación.
    // El username y password deben ser distinto de null
    // El username no debe estar registrado en la base de datos
    @Transactional
    public Company registrar(Company company) {
        Optional<Company> companyBD = companyRepository.findByUsername(company.getUsername());
        if (companyBD.isPresent())
            throw new CustomerServiceException("La empresa " + company.getUsername() + " ya está registrada");
        else if (company.getUsername() == null)
            throw new CustomerServiceException("La empresa no tiene username");
        else if (company.getPassword() == null)
            throw new CustomerServiceException("La empresa no tiene password");
        else
            return companyRepository.save(company);
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
        company.setPassword(managerUserSession.encryptPassword(modificarCompanyData.getNewPassword()));
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

    @Transactional
    public Company actualizarImagen(Long idCompany, int numberImg, String fileName) {
        logger.debug("Actualizando imagen " + numberImg + " de la empresa " + idCompany);
        Company company = companyRepository.findById(idCompany).orElse(null);
        if (company == null) {
            throw new CompanyServiceException("No existe empresa con id " + idCompany);
        }
        switch (numberImg){
            case 1:
                company.setImg1(fileName.toString());
                break;
            case 2:
                company.setImg2(fileName.toString());
                break;
            case 3:
                company.setImg3(fileName.toString());
                break;
            case 4:
                company.setImg4(fileName.toString());
                break;
            case 5:
                company.setImg5(fileName.toString());
                break;
        }
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
        int contadorHombres = appointmentRepository.numeroClientesHombres(company.getId());
        int contadorMujeres = appointmentRepository.numeroClientesMujeres(company.getId());
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
        for(Labour servicio : company.getActivatedLabours()){
            resultado.add(servicio.getName());
        }
        return resultado;
    }

    @Transactional(readOnly = true)
    public ArrayList<Integer> obtenerTotalReservasPorServicioActivo(Company company){
        ArrayList<Integer> resultado = new ArrayList<>();
        for(Labour servicio : company.getActivatedLabours()){
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
        for(Labour servicio : company.getActivatedLabours()){
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
        // Hay perfil y es sql. Ejecutamos MySQL
        if(env.getActiveProfiles().length != 0 &&
                Arrays.stream(env.getActiveProfiles()).anyMatch(env -> (env.equalsIgnoreCase("sql")))){
            valores = numeroNuevosClientesIncrementalMySQL(company.getId(), fechas);
        }else{  // No hay perfil activado. Estamos ejecutando H2-CONSOLE
            valores = numeroNuevosClientesIncrementalH2(company.getId(), fechas);
        }
        TraceHistoricoGrafico trace = new TraceHistoricoGrafico("Nuevos clientes", fechas, valores);
        HistoricoNuevosClientesGrafico grafico = new HistoricoNuevosClientesGrafico(trace, fechaInicioRango, fechaFinRango);
        return grafico;
    }

    @Transactional(readOnly = true)
    public StatisticsRankingCard obtenerRankingServiciosMasReservados(Company company){
        List<String> nombresServicios;
        List<Double> cantidadReservas;
        nombresServicios = labourRepository.nombresTresServiciosMasReservados(company.getCategory().getId());
        cantidadReservas = labourRepository.cantidadTresServiciosMasReservados(company.getCategory().getId());
        return new StatisticsRankingCard(new ArrayList<>(nombresServicios), new ArrayList<>(cantidadReservas));
    }

    @Transactional(readOnly = true)
    public StatisticsRankingCard obtenerRankingEmpresasMasIngresos(Company company){
        List<String> nombresEmpresas;
        List<Double> cantidadIngresos;
        nombresEmpresas = appointmentRepository.nombresTopTresEmpresasIngresosTotalesEsteMes(company.getCategory().getId());
        cantidadIngresos = appointmentRepository.ingresosTotalesTopTresEmpresasEsteMes(company.getCategory().getId());
        return new StatisticsRankingCard(new ArrayList<>(nombresEmpresas), new ArrayList<>(cantidadIngresos));
    }

    @Transactional(readOnly = true)
    public StatisticsRankingCard obtenerRankingEmpresasMejoresReviews(Company company){
        List<String> nombresEmpresas;
        List<Double> mediasReviews;
        nombresEmpresas = reviewRepository.nombresTopTresEmpresasMejoresReviews(company.getCategory().getId());
        mediasReviews = reviewRepository.mediasReviewsTopTresEmpresas(company.getCategory().getId());
        return new StatisticsRankingCard(new ArrayList<>(nombresEmpresas), new ArrayList<>(mediasReviews));
    }

    @Transactional(readOnly = true)
    public ArrayList<StatisticsRankingCard> obtenerCartasRankingEstadisticas(Company company){
        ArrayList<StatisticsRankingCard> cartas = new ArrayList<>();
        cartas.add(obtenerRankingServiciosMasReservados(company));
        cartas.add(obtenerRankingEmpresasMasIngresos(company));
        cartas.add(obtenerRankingEmpresasMejoresReviews(company));
        return cartas;
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

    @Transactional(readOnly = true)
    public List<Appointment> obtenerReservas(Company company){
        return appointmentRepository.listarReservasEmpresa(company.getId());
    }

    public Page<Company> paginar(Pageable pageable, List<Company> listaEmpresas) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Company> list;

        if (listaEmpresas.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, listaEmpresas.size());
            list = listaEmpresas.subList(startItem, toIndex);
        }

        Page<Company> listPage
                = new PageImpl<Company>(list, PageRequest.of(currentPage, pageSize), listaEmpresas.size());

        return listPage;
    }

    @Transactional(readOnly = true)
    public HashSet<Company> criterioCategoria(String categoria){
        List<Company> lista = new ArrayList<>();
        if(!categoria.equals("Categoria")){
            Category category = categoryRepository.findByName(categoria).orElse(null);
            if(category != null){
                lista = companyRepository.empresasPorCategoria(category.getId());
            }
        }else{
            lista = companyRepository.todasLasEmpresas();
        }
        return new HashSet<Company>(lista);
    }

    @Transactional(readOnly = true)
    public HashSet<Company> criterioServicio(String servicio, HashSet<Labour> hashServicios){
        HashSet<Company> hash = new HashSet<>();
        if(!servicio.equals("")){
            ArrayList<String> stopWords = new ArrayList<>(Arrays.asList("a", "de", "desde", "durante", "en", "hasta",
                    "por", "sobre", "tras"));
            String[] palabras = servicio.split(" ");
            for(int i = 0; i < palabras.length; i++){
                if(!palabras[i].isEmpty() && !stopWords.contains(palabras[i])){
                    hash.addAll(companyRepository.empresasPorServicio("%" + palabras[i] + "%"));
                    hashServicios.addAll(labourRepository.serviciosPorNombreLike("%" + palabras[i] + "%"));
                }
            }
        }else{
            hash = new HashSet<>(companyRepository.todasLasEmpresas());
            hashServicios.addAll(labourRepository.serviciosDuracionMinimaPorEmpresa());
        }
        return hash;
    }

    private String peticionGetDistancia(URL url) throws IOException {
        StringBuilder resultado = new StringBuilder();
        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        return resultado.toString();
    }

    private HashMap<Company, Integer> crearMapaEmpresasDistancias(HashSet<Company> empresas){
        HashMap<Company, Integer> resultado = new HashMap<>();
        for (Company empresa : empresas) {
            resultado.put(empresa, null);
        }
        return resultado;
    }

    private void mapaIntroducirDistancias(HashMap<Company, Integer> mapa, ArrayList<Integer> distancias){
        int i = 0;
        for (Company empresa : mapa.keySet()) {
            mapa.put(empresa, distancias.get(i));
            i++;
        }
    }

    private void mapaEliminarEmpresasSegunDistancia(HashMap<Company, Integer> mapa, int limiteDistancia){
        if(limiteDistancia != -1){
            HashMap<Company, Integer> mapaCopia = new HashMap<>(mapa);
            for (Company empresa : mapaCopia.keySet()) {
                if(mapaCopia.get(empresa) == -1 || mapaCopia.get(empresa) > limiteDistancia){
                    mapa.remove(empresa);
                }
            }
        }
    }

    @Transactional(readOnly = true)
    public HashSet<Company> criterioUbicacion(HashSet<Company> lista, String ubicacion, int distanciaLimite){
        HashMap<Company, Integer> mapaEmpresasDistancias = new HashMap<>();
        if(!ubicacion.equals("")){
            URL url = null;
            try {
                StringBuilder cadena = new StringBuilder();
                mapaEmpresasDistancias = crearMapaEmpresasDistancias(lista);

                // Si lista es vacío el stringbuilder puede traer problemas ya que no cargaria valor y se haría la pet GET

                for (Company empresa: mapaEmpresasDistancias.keySet()) {
                    cadena.append(empresa.getAddress());
                    cadena.append("|");
                }

                ubicacion = ubicacion.replace(" ", "");
                String ubicacionesEmpresas = cadena.toString().replace(" ", "");
                String key = ApiKeyMatrix.getKey();

                url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + ubicacion +
                        "&destinations=" + ubicacionesEmpresas + "&key=" +
                        ApiKeyMatrix.getKey());

                String resultadoPeticion = peticionGetDistancia(url);

                JSONObject objetoJson = new JSONObject(resultadoPeticion);
                if(objetoJson.getString("status").equals("OK")){

                    JSONArray elementos = objetoJson.getJSONArray("rows").getJSONObject(0).getJSONArray("elements");

                    ArrayList<Integer> distancias = new ArrayList<>();
                    for (int indice = 0; indice < elementos.length(); indice++) {
                        if(elementos.getJSONObject(indice).getString("status").equals("OK")){
                            int distancia = elementos.getJSONObject(indice).getJSONObject("distance").getInt("value");
                            distancias.add(distancia);
                        }else{
                            distancias.add(-1);
                        }
                    }

                    mapaIntroducirDistancias(mapaEmpresasDistancias, distancias);
                    mapaEliminarEmpresasSegunDistancia(mapaEmpresasDistancias, distanciaLimite);
                    return new HashSet<>(mapaEmpresasDistancias.keySet());
                }else {
                    return new HashSet<>();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lista;
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

    public boolean tieneHuecoParaServicio(Company empresa, Labour servicio, String fecha){
        Date dateFecha = convertToDate(fecha);
        List<Appointment> reservasEseDia = appointmentRepository.todasLasReservasDelDia(empresa.getId(), dateFecha);
        LocalTime horaInicio = LocalTime.parse(empresa.getStartday());
        // LocalTime horaFin = horaInicio.plusMinutes(labour.getDuration());
        for(Appointment reserva : reservasEseDia){
            LocalTime siguienteHora = LocalTime.parse(reserva.getStarthour());
            Long diferencia = Math.abs(MINUTES.between(horaInicio, siguienteHora));
            if(diferencia >= servicio.getDuration()){
                return true;
            }
            horaInicio = LocalTime.parse(reserva.getEndhour());
        }

        LocalTime horaFin = LocalTime.parse(empresa.getFinishday());
        Long diferencia = Math.abs(MINUTES.between(horaInicio, horaFin));
        if(diferencia >= servicio.getDuration()){
            return true;
        }

        return false;
    }

    @Transactional(readOnly = true)
    public HashSet<Company> criterioFecha(HashSet<Company> empresas, HashSet<Labour> servicios, String fecha){
        HashSet<Company> empresasSetServicios = new HashSet<>();
        if(!fecha.equals("")){
            for(Labour servicio : servicios){
                if(tieneHuecoParaServicio(servicio.getCompany(), servicio, fecha)){
                    empresasSetServicios.add(servicio.getCompany());
                }
            }
            return empresasSetServicios;
        }
        return empresas;
    }

    private void innerJoinHashSet(HashSet<Company> hash1, HashSet<Company> hash2){
        HashSet<Company> copiaHash1 = new HashSet<>(hash1);
        for(Company company : copiaHash1){
            if(!hash2.contains(company)){
                hash1.remove(company);
            }
        }
    }

    @Transactional(readOnly = true)
    public List<Company> criteriosBuscador(String categoria, String servicio, String ubicacion, String fecha, int distanciaLimite){

        HashSet<Company> hashSet = new HashSet<>();
        HashSet<Labour> hashSetServicios = new HashSet<>();

        hashSet = criterioCategoria(categoria);

        innerJoinHashSet(hashSet, criterioServicio(servicio, hashSetServicios));

        innerJoinHashSet(hashSet, criterioUbicacion(hashSet, ubicacion, distanciaLimite));

        innerJoinHashSet(hashSet, criterioFecha(hashSet, hashSetServicios, fecha));

        return  new ArrayList<>(hashSet);
    }

}
