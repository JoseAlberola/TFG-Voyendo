package voyendo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LabourRepository extends CrudRepository<Labour, Long> {
    Optional<Labour> findByName(String s);
    List<Labour> findByCompany(Company c);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM LABOURS WHERE company_id = ?1 AND activated = true")
    int numeroServiciosActivados(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT * FROM LABOURS WHERE LOWER(name) LIKE LOWER(?1) AND activated = true")
    List<Labour> serviciosPorNombreLike(String cadena);

    @Query(nativeQuery = true, value = "SELECT * FROM (SELECT ROW_NUMBER() OVER(PARTITION BY company_id ORDER BY duration) " +
            "as idrow, a.* FROM labours as a) as b WHERE idrow=1;")
    List<Labour> serviciosDuracionMinimaPorEmpresa();

    @Query(nativeQuery = true, value = "SELECT l.name FROM LABOURS l INNER JOIN (SELECT a.labour_id FROM APPOINTMENTS a " +
            "INNER JOIN COMPANIES c ON a.company_id = c.id WHERE c.category_id = ?1 GROUP BY a.labour_id ORDER BY " +
            "COUNT(a.id) DESC LIMIT 3) ON labour_id = l.id")
    List<String> nombresTresServiciosMasReservados(Long idCategory);

    @Query(nativeQuery = true, value = "SELECT count(a.id) FROM APPOINTMENTS a INNER JOIN COMPANIES c ON a.company_id = c.id " +
            "WHERE c.category_id = ?1 GROUP BY a.labour_id ORDER BY COUNT(a.id) DESC LIMIT 3")
    List<Double> cantidadTresServiciosMasReservados(Long idCategory);
}
