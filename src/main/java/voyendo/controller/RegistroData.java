package voyendo.controller;

import javax.validation.constraints.Email;

public class RegistroData {
    private String username;
    @Email
    private String mail;
    private String password;
    private String name;
    private String phone;
    private String tipoRegistro;

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getTipoRegistro() { return tipoRegistro; }

    public void setTipoRegistro(String tipoRegistro) { this.tipoRegistro = tipoRegistro; }
}
