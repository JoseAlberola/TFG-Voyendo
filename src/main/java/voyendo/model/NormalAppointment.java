package voyendo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@DiscriminatorValue("1")
public class NormalAppointment extends Appointment{
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    public NormalAppointment() {}

    // Al crear un servicio lo asociamos automáticamente a una
    // compñía. Actualizamos por tanto la lista de servicios de la
    // compañía.
    public NormalAppointment(Date date, Company company, Labour labour, Customer customer) {
        super(date, company, labour);
        this.customer = customer;
        customer.getAppointments().add(this);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
