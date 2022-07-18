package voyendo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
// import java.util.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
    private boolean premium;
    @Column(columnDefinition = "varchar(255) default 'defaultAvatar.jpg'")
    private String img1;
    @Column(columnDefinition = "varchar(255) default 'defaultAvatar.jpg'")
    private String img2;
    @Column(columnDefinition = "varchar(255) default 'defaultAvatar.jpg'")
    private String img3;
    @Column(columnDefinition = "varchar(255) default 'defaultAvatar.jpg'")
    private String img4;
    @Column(columnDefinition = "varchar(255) default 'defaultAvatar.jpg'")
    private String img5;
    @Column(columnDefinition = "boolean default true")
    private boolean lunes;
    @Column(columnDefinition = "boolean default true")
    private boolean martes;
    @Column(columnDefinition = "boolean default true")
    private boolean miercoles;
    @Column(columnDefinition = "boolean default true")
    private boolean jueves;
    @Column(columnDefinition = "boolean default true")
    private boolean viernes;
    @Column(columnDefinition = "boolean default false")
    private boolean sabado;
    @Column(columnDefinition = "boolean default false")
    private boolean domingo;

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
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @JsonManagedReference
    Set<Labour> labours = new HashSet<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @JsonManagedReference
    Set<Review> reviews = new HashSet<>();

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

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
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

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getImg5() {
        return img5;
    }

    public void setImg5(String img5) {
        this.img5 = img5;
    }

    public boolean isLunes() {
        return lunes;
    }

    public void setLunes(boolean lunes) {
        this.lunes = lunes;
    }

    public boolean isMartes() {
        return martes;
    }

    public void setMartes(boolean martes) {
        this.martes = martes;
    }

    public boolean isMiercoles() {
        return miercoles;
    }

    public void setMiercoles(boolean miercoles) {
        this.miercoles = miercoles;
    }

    public boolean isJueves() {
        return jueves;
    }

    public void setJueves(boolean jueves) {
        this.jueves = jueves;
    }

    public boolean isViernes() {
        return viernes;
    }

    public void setViernes(boolean viernes) {
        this.viernes = viernes;
    }

    public boolean isSabado() {
        return sabado;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public Set<Labour> getActivatedLabours() {
        Set resultado = new HashSet();
        for (Labour labour: labours) {
            if(labour.isActivated()){
                resultado.add(labour);
            }
        }
        return resultado;
    }

    public int getPositiveReviews() {
        int counter = 0;
        for (Review review: reviews) {
            if(review.getValuation() >= 4){
                counter++;
            }
        }
        return counter;
    }

    public int getNegativeReviews() {
        int counter = 0;
        for (Review review: reviews) {
            if(review.getValuation() <= 2){
                counter++;
            }
        }
        return counter;
    }

    public int getNeutralReviews() {
        int counter = 0;
        for (Review review: reviews) {
            if(review.getValuation() == 3){
                counter++;
            }
        }
        return counter;
    }

    public String valoracionMedia() {
        int counter = 0;
        DecimalFormat df = new DecimalFormat("#.#");
        if(reviews.size() == 0){
            return "0";
        }else{
            for (Review review: reviews) {
                counter += review.getValuation();
            }
        }
        return df.format((counter * 1.0) / reviews.size());
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
