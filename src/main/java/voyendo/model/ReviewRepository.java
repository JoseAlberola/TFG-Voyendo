package voyendo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM REVIEWS WHERE company_id = ?1")
    List<Review> reviewsDeEmpresa(Long idCompany);

    @Query(nativeQuery = true, value = "SELECT c.name FROM REVIEWS r INNER JOIN COMPANIES c ON r.company_id = c.id WHERE " +
            "c.category_id = ?1 GROUP BY r.company_id ORDER BY ROUND(AVG(CAST(valuation AS FLOAT)), 1) DESC, " +
            "COUNT(r.id) DESC LIMIT 3;")
    List<String> nombresTopTresEmpresasMejoresReviews(Long idCategory);

    @Query(nativeQuery = true, value = "SELECT ROUND(AVG(CAST(valuation AS FLOAT)), 1) lamedia FROM REVIEWS r INNER JOIN " +
            "COMPANIES c ON r.company_id = c.id WHERE c.category_id = ?1 GROUP BY r.company_id ORDER BY lamedia DESC, " +
            "COUNT(r.id) DESC LIMIT 3")
    List<Double> mediasReviewsTopTresEmpresas(Long idCategory);
}
