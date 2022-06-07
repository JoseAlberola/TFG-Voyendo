package voyendo.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LabourRepository extends CrudRepository<Labour, Long> {
    Optional<Labour> findByName(String s);
    List<Labour> findByCompany(Company c);
}
