package voyendo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;
    private String starthour;
    private String endhour;

    @NotNull
    // Relación muchos-a-uno entre servicios y compañias
    @ManyToOne
    // Nombre de la columna en la BD que guarda físicamente
    // el ID de la compañía con el que está asociado un servicio
    @JoinColumn(name = "company_id")
    private Company company;

    // Relación muchos-a-uno entre servicios y clientes
    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "labour_id")
    private Labour labour;

    // Constructor vacío necesario para JPA/Hibernate.
    // Lo hacemos privado para que no se pueda usar desde el código de la aplicación. Para crear un
    // usuario en la aplicación habrá que llamar al constructor público. Hibernate sí que lo puede usar, a pesar
    // de ser privado.
    private Appointment() {}

    // Al crear un servicio lo asociamos automáticamente a una
    // compñía. Actualizamos por tanto la lista de servicios de la
    // compañía.
    public Appointment(Date date, Company company, Customer customer, Labour labour) {
        this.date = date;
        this.company = company;
        company.getAppointments().add(this);
        this.customer = customer;
        customer.getAppointments().add(this);
        this.labour = labour;
        labour.getAppointments().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStarthour() {
        return starthour;
    }

    public void setStarthour(String starthour) {
        this.starthour = starthour;
    }

    public String getEndhour() {
        return endhour;
    }

    public void setEndhour(String endhour) {
        this.endhour = endhour;
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

    public Labour getLabour() {
        return labour;
    }

    public void setLabour(Labour labour) {
        this.labour = labour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment appointment = (Appointment) o;
        if (id != null && appointment.id != null)
            // Si tenemos los ID, comparamos por ID
            return Objects.equals(id, appointment.id);
        // sino comparamos por campos obligatorios
        return date.equals(appointment.date) && company.equals(appointment.company) && customer.equals(appointment.customer)
                && labour.equals(appointment.labour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, company, customer, labour);
    }
}
