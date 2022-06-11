package voyendo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
// import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String name;
    @NotNull
    private String mail;
    private String password;
    private String phone;
    @NotNull
    private String address;
    private String startday;
    private String finishday;

    // Definimos el tipo de fetch como EAGER para que
    // cualquier consulta que devuelve un usuario rellene automáticamente
    // toda su lista de tareas
    // CUIDADO!! No es recomendable hacerlo en aquellos casos en los
    // que la relación pueda traer a memoria una gran cantidad de entidades
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @JsonManagedReference
    Set<Appointment> appointments = new HashSet<>();

    @NotNull
    // Relación muchos-a-uno entre compañías y categorías
    @ManyToOne
    // Nombre de la columna en la BD que guarda físicamente
    // el ID de la compañía con el que está asociado una categoría
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    Set<Labour> labours = new HashSet<>();

    // @ManyToMany(mappedBy = "usuarios", fetch = FetchType.EAGER)
    // Set<Equipo> equipos = new HashSet<>();

    // Constructor vacío necesario para JPA/Hibernate.
    // Lo hacemos privado para que no se pueda usar desde el código de la aplicación. Para crear un
    // usuario en la aplicación habrá que llamar al constructor público. Hibernate sí que lo puede usar, a pesar
    // de ser privado.
    private Company() {}

    // Constructor público con los atributos obligatorios. En este caso el correo electrónico.
    public Company(String username, String name, String mail, String address, Category category) {
        this.username = username;
        this.name = name;
        this.mail = mail;
        this.address = address;
        this.category = category;
        category.getCompanies().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartday() {
        return startday;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }

    public String getFinishday() {
        return finishday;
    }

    public void setFinishday(String finishday) {
        this.finishday = finishday;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public Set<Labour> getLabours() {
        return labours;
    }

    public void setLabours(Set<Labour> labours) {
        this.labours = labours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        if (id != null && company.id != null)
            // Si tenemos los ID, comparamos por ID
            return Objects.equals(id, company.id);
        // sino comparamos por campos obligatorios
        return username.equals(company.username) && name.equals(company.name) && mail.equals(company.mail)
                && address.equals(company.address) && category.equals(company.category);
    }

    @Override
    public int hashCode() {
        // Generamos un hash basado en los campos obligatorios
        return Objects.hash(username, name, mail, address, category);
    }
}
