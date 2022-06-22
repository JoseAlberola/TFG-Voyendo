package voyendo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("2")
public class GuestAppointment extends Appointment{
    private String name;

    public GuestAppointment() {}

    // Al crear un servicio lo asociamos automáticamente a una
    // compñía. Actualizamos por tanto la lista de servicios de la
    // compañía.
    public GuestAppointment(Date date, Company company, Labour labour, String name) {
        super(date, company, labour);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
