package voyendo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String text;
    @NotNull
    private int valuation;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private Company company;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    // Constructor vacío necesario para JPA/Hibernate.
    // Lo hacemos privado para que no se pueda usar desde el código de la aplicación. Para crear un
    // usuario en la aplicación habrá que llamar al constructor público. Hibernate sí que lo puede usar, a pesar
    // de ser privado.
    public Review() {}

    // Al crear un servicio lo asociamos automáticamente a una
    // compñía. Actualizamos por tanto la lista de servicios de la
    // compañía.
    public Review(String text, int valuation, Company company, Customer customer) {
        this.text = text;
        this.valuation = valuation;
        this.company = company;
        company.getReviews().add(this);
        this.customer = customer;
        customer.getReviews().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValuation() {
        return valuation;
    }

    public void setValuation(int valuation) {
        this.valuation = valuation;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        if (id != null && review.id != null)
            // Si tenemos los ID, comparamos por ID
            return Objects.equals(id, review.id);
        // sino comparamos por campos obligatorios
        return text.equals(review.text) && valuation == review.valuation && company.equals(review.company)
                && customer.equals(review.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, valuation, company, customer);
    }
}
