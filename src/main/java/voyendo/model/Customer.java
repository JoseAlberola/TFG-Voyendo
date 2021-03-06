package voyendo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

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
    private String gender;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(columnDefinition = "varchar(255) default 'defaultAvatar.jpg'")
    private String img1;

    // Definimos el tipo de fetch como EAGER para que
    // cualquier consulta que devuelve un usuario rellene automáticamente
    // toda su lista de tareas
    // CUIDADO!! No es recomendable hacerlo en aquellos casos en los
    // que la relación pueda traer a memoria una gran cantidad de entidades
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonManagedReference
    Set<NormalAppointment> appointments = new HashSet<>();

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonManagedReference
    Set<Review> reviews = new HashSet<>();

    // Constructor vacío necesario para JPA/Hibernate.
    // Lo hacemos privado para que no se pueda usar desde el código de la aplicación. Para crear un
    // usuario en la aplicación habrá que llamar al constructor público. Hibernate sí que lo puede usar, a pesar
    // de ser privado.
    private Customer() {}

    // Constructor público con los atributos obligatorios.
    public Customer(String username, String name, String mail, String gender, Date birthday) {
        this.username = username;
        this.name = name;
        this.mail = mail;
        this.gender = gender;
        this.birthday = birthday;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getBirthdayString() {
        return birthday.toString();
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public Set<NormalAppointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<NormalAppointment> appointments) {
        this.appointments = appointments;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Review getReviewEmpresa(Long idCompany){
        for(Review review : reviews){
            if(review.getCompany().getId() == idCompany){
                return review;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        if (id != null && customer.id != null)
            // Si tenemos los ID, comparamos por ID
            return Objects.equals(id, customer.id);
        // sino comparamos por campos obligatorios
        return username.equals(customer.username) && name.equals(customer.name) && mail.equals(customer.mail)
                && gender.equals(customer.gender) && birthday.equals(customer.birthday);
    }

    @Override
    public int hashCode() {
        // Generamos un hash basado en los campos obligatorios
        return Objects.hash(username, name, mail, gender, birthday);
    }
}
