package voyendo.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    List<Category> findAllByOrderByNameAsc();
    Optional<Category> findByName(String s);
}
