package voyendo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    Optional<Company> findByUsername(String s);
    Optional<Company> findByMail(String s);

    @Query(nativeQuery = true, value = "SELECT * FROM COMPANIES")
    List<Company> todasLasEmpresas();

    @Query(nativeQuery = true, value = "SELECT * FROM COMPANIES WHERE category_id = ?1")
    List<Company> empresasPorCategoria(Long idCategoria);

    @Query(nativeQuery = true, value = "SELECT c.* FROM COMPANIES c INNER JOIN (SELECT * FROM LABOURS WHERE LOWER(name) LIKE " +
            "LOWER(?1)) l ON c.id = l.company_id GROUP BY c.id")
    List<Company> empresasPorServicio(String servicio);
}
