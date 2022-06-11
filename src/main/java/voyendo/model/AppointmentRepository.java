package voyendo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM APPOINTMENTS WHERE date BETWEEN CURDATE() - INTERVAL 1 MONTH " +
            "AND CURDATE() AND company_id = ?1")
    double totalAppointmentsThisMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM APPOINTMENTS WHERE date BETWEEN CURDATE() - INTERVAL 2 MONTH " +
            "AND CURDATE() - INTERVAL 1 MONTH AND company_id = ?1")
    double totalAppointmentsLastMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT SUM(price) FROM APPOINTMENTS INNER JOIN LABOURS ON APPOINTMENTS.labour_id = " +
            "LABOURS.id WHERE date BETWEEN CURDATE() - INTERVAL 1 MONTH AND CURDATE() AND APPOINTMENTS.company_id = ?1")
    double totalRevenueThisMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT SUM(price) FROM APPOINTMENTS INNER JOIN LABOURS ON APPOINTMENTS.labour_id = " +
            "LABOURS.id WHERE date BETWEEN CURDATE() - INTERVAL 2 MONTH AND CURDATE() - INTERVAL 1 MONTH AND APPOINTMENTS.company_id = ?1")
    double totalRevenueLastMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT customer_id) FROM APPOINTMENTS WHERE date BETWEEN " +
            "CURDATE() - INTERVAL 1 MONTH AND CURDATE() AND company_id = ?1")
    double totalCustomersThisMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(DISTINCT customer_id) FROM APPOINTMENTS WHERE date BETWEEN " +
            "CURDATE() - INTERVAL 2 MONTH AND CURDATE() - INTERVAL 1 MONTH AND company_id = ?1")
    double totalCustomersLastMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM (SELECT * FROM APPOINTMENTS WHERE date BETWEEN " +
            "CURDATE() - INTERVAL 1 MONTH AND CURDATE() AND company_id = ?1) t1 LEFT JOIN (SELECT * FROM APPOINTMENTS " +
            "WHERE company_id = ?1 AND date < CURDATE() - INTERVAL 1 MONTH) t2 ON t1.customer_id = t2.customer_id WHERE " +
            "t2.customer_id IS NULL;")
    double totalNewCustomersThisMonth(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM (SELECT * FROM APPOINTMENTS WHERE date BETWEEN " +
            "CURDATE() - INTERVAL 2 MONTH AND CURDATE() - INTERVAL 1 MONTH AND company_id = ?1) t1 LEFT JOIN (SELECT * " +
            "FROM APPOINTMENTS WHERE company_id = ?1 AND date < CURDATE() - INTERVAL 2 MONTH) t2 ON t1.customer_id = t2.customer_id " +
            "WHERE t2.customer_id IS NULL")
    double totalNewCustomersLastMonth(Long idCompany);
}
