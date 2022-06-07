package voyendo.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    Optional<Company> findByUsername(String s);
    Optional<Company> findByMail(String s);
}
