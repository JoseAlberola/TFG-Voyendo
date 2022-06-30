package voyendo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM REVIEWS WHERE company_id = ?1")
    List<Review> reviewsDeEmpresa(Long idCompany);
}
