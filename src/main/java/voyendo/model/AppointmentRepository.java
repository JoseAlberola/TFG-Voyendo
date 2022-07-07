package voyendo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import voyendo.controller.graficos.HistoricoReservasGrafico;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM APPOINTMENTS WHERE company_id = ?1 AND " +
            "date = ?2 ORDER BY date, starthour")
    List<Appointment> todasLasReservasDelDia(Long idCompany, Date fecha);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM APPOINTMENTS a INNER JOIN CUSTOMERS c ON " +
            "a.customer_id = c.id WHERE a.company_id = ?1 AND a.appointment_type = 1 AND c.gender = 'male'")
    int numeroClientesHombres(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM APPOINTMENTS a INNER JOIN CUSTOMERS c ON " +
            "a.customer_id = c.id WHERE a.company_id = 1 AND a.appointment_type = 1 AND c.gender = 'female'")
    int numeroClientesMujeres(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM APPOINTMENTS WHERE date BETWEEN CURDATE() - INTERVAL 1 MONTH " +
            "AND CURDATE() AND company_id = ?1")
    double totalAppointmentsThisMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM APPOINTMENTS WHERE date BETWEEN CURDATE() - INTERVAL 2 MONTH " +
            "AND CURDATE() - INTERVAL 1 MONTH AND company_id = ?1")
    double totalAppointmentsLastMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT IFNULL(SUM(price), 0) FROM APPOINTMENTS INNER JOIN LABOURS ON " +
            "APPOINTMENTS.labour_id = LABOURS.id WHERE date BETWEEN CURDATE() - INTERVAL 1 MONTH AND CURDATE() AND " +
            "APPOINTMENTS.company_id = ?1")
    double totalRevenueThisMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT IFNULL(SUM(price), 0) FROM APPOINTMENTS INNER JOIN LABOURS ON APPOINTMENTS.labour_id = " +
            "LABOURS.id WHERE date BETWEEN CURDATE() - INTERVAL 2 MONTH AND CURDATE() - INTERVAL 1 MONTH AND APPOINTMENTS.company_id = ?1")
    double totalRevenueLastMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT customer_id) FROM APPOINTMENTS WHERE date BETWEEN " +
            "CURDATE() - INTERVAL 1 MONTH AND CURDATE() AND company_id = ?1 AND appointment_type = 1")
    double totalCustomersThisMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT customer_id) FROM APPOINTMENTS WHERE date BETWEEN " +
            "CURDATE() - INTERVAL 2 MONTH AND CURDATE() - INTERVAL 1 MONTH AND company_id = ?1 AND appointment_type = 1")
    double totalCustomersLastMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM (SELECT * FROM APPOINTMENTS WHERE date BETWEEN " +
            "CURDATE() - INTERVAL 1 MONTH AND CURDATE() AND company_id = ?1 AND appointment_type = 1) t1 LEFT JOIN (SELECT * FROM APPOINTMENTS " +
            "WHERE company_id = ?1 AND appointment_type =1 AND date < CURDATE() - INTERVAL 1 MONTH) t2 ON t1.customer_id = t2.customer_id WHERE " +
            "t2.customer_id IS NULL;")
    double totalNewCustomersThisMonth(Long idCompany);

    // METODO MySQL
    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT t1.customer_id) FROM (SELECT * FROM APPOINTMENTS WHERE date BETWEEN " +
            "DATE(?2) - INTERVAL 1 MONTH AND DATE(?2) AND company_id = ?1 AND appointment_type = 1) t1 LEFT JOIN (SELECT * FROM APPOINTMENTS " +
            "WHERE company_id = ?1 AND appointment_type = 1 AND date < DATE(?2) - INTERVAL 1 MONTH) t2 ON t1.customer_id = t2.customer_id WHERE " +
            "t2.customer_id IS NULL;")
    int totalNewCustomersOnMonthMySQL(Long idCompany, String date);

    // METODO H2-CONSOLE
    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT t1.customer_id) FROM (SELECT * FROM APPOINTMENTS WHERE date BETWEEN " +
            "PARSEDATETIME(?2, 'yyyy-MM-dd') - INTERVAL 1 MONTH AND PARSEDATETIME(?2, 'yyyy-MM-dd') AND company_id = ?1 AND appointment_type = 1) " +
            "t1 LEFT JOIN (SELECT * FROM APPOINTMENTS WHERE company_id = ?1 AND appointment_type = 1 AND date < PARSEDATETIME(?2, 'yyyy-MM-dd') " +
            "- INTERVAL 1 MONTH) t2 ON t1.customer_id = t2.customer_id WHERE t2.customer_id IS NULL")
    int totalNewCustomersOnMonthH2(Long company_id, String date);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM (SELECT * FROM APPOINTMENTS WHERE date BETWEEN " +
            "CURDATE() - INTERVAL 2 MONTH AND CURDATE() - INTERVAL 1 MONTH AND company_id = ?1 AND appointment_type = 1) t1 LEFT JOIN (SELECT * " +
            "FROM APPOINTMENTS WHERE company_id = ?1 AND appointment_type = 1 AND date < CURDATE() - INTERVAL 2 MONTH) t2 ON t1.customer_id = t2.customer_id " +
            "WHERE t2.customer_id IS NULL")
    double totalNewCustomersLastMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT A.customer_id) FROM APPOINTMENTS A LEFT JOIN CUSTOMERS C " +
            "ON A.customer_id = C.id WHERE company_id = ?1 AND appointment_type = 1 AND TIMESTAMPDIFF(YEAR,birthday,CURDATE()) <= 25;")
    int clientesMenores25(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT A.customer_id) FROM APPOINTMENTS A LEFT JOIN CUSTOMERS C " +
            "ON A.customer_id = C.id WHERE company_id = ?1 AND appointment_type = 1 AND TIMESTAMPDIFF(YEAR,birthday,CURDATE()) > 25 AND " +
            "TIMESTAMPDIFF(YEAR,birthday,CURDATE()) <= 45;")
    int clientesEntre26y45(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT A.customer_id) FROM APPOINTMENTS A LEFT JOIN CUSTOMERS C " +
            "ON A.customer_id = C.id WHERE company_id = ?1 AND appointment_type = 1 AND TIMESTAMPDIFF(YEAR,birthday,CURDATE()) > 45 AND " +
            "TIMESTAMPDIFF(YEAR,birthday,CURDATE()) <= 65;")
    int clientesEntre46y65(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT A.customer_id) FROM APPOINTMENTS A LEFT JOIN CUSTOMERS C " +
            "ON A.customer_id = C.id WHERE company_id = ?1 AND appointment_type = 1 AND TIMESTAMPDIFF(YEAR,birthday,CURDATE()) > 65")
    int clientesMayores65(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM APPOINTMENTS WHERE company_id = ?1 AND labour_id = ?2")
    int totalReservasPorServicio(Long idCompany, Long idLabour);

    @Query(nativeQuery = true, value = "SELECT DATE FROM APPOINTMENTS WHERE company_id = ?1 AND labour_id = ?2 ORDER BY DATE")
    List<Date> fechasReservasPorServicio(Long idCompany, Long idLabour);

    @Query(nativeQuery = true, value = "SELECT DATE FROM APPOINTMENTS WHERE company_id = ?1")
    List<Date> fechasTodasLasReservas(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT  COUNT(*) as total FROM APPOINTMENTS WHERE company_id = ?1 AND labour_id = ?2 " +
            "GROUP BY year(DATE), MONTH(DATE) ORDER BY year(DATE), MONTH(DATE)")
    List<Integer> reservasPorServicioMes(Long idCompany, Long idLabour);

    @Query(nativeQuery = true, value = "SELECT DATE FROM APPOINTMENTS WHERE company_id = ?1 ORDER BY DATE LIMIT 1")
    Date fechaPrimeraReserva(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT DATE FROM APPOINTMENTS WHERE company_id = ?1 ORDER BY DATE DESC LIMIT 1")
    Date fechaUltimaReserva(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT * FROM APPOINTMENTS a " +
            "INNER JOIN LABOURS l ON a.labour_id = l.id WHERE a.company_id = ?1 ORDER BY DATE")
    List<Appointment> listarReservasEmpresa(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT c.name FROM APPOINTMENTS a INNER JOIN LABOURS l ON a.labour_id = l.id " +
            "INNER JOIN COMPANIES c ON a.company_id = c.id WHERE date BETWEEN CURDATE() - INTERVAL 1 MONTH AND " +
            "CURDATE() AND c.category_id = ?1 GROUP BY a.company_id ORDER BY IFNULL(SUM(price), 0) DESC LIMIT 3")
    List<String> nombresTopTresEmpresasIngresosTotalesEsteMes(Long idCategory);

    @Query(nativeQuery = true, value = "SELECT IFNULL(SUM(price), 0) suma FROM APPOINTMENTS a INNER JOIN LABOURS l ON " +
            "a.labour_id = l.id INNER JOIN COMPANIES c ON a.company_id = c.id WHERE date BETWEEN CURDATE() - INTERVAL 1 " +
            "MONTH AND CURDATE() AND c.category_id = ?1 GROUP BY a.company_id ORDER BY suma DESC LIMIT 3")
    List<Double> ingresosTotalesTopTresEmpresasEsteMes(Long idCategory);
}
