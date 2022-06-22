package voyendo.controller.Data;

import voyendo.model.Category;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ModificarCompanyData {
    private String username;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String mail;
    private String phone;
    private String address;
    @NotBlank
    private String password;
    @NotBlank
    private String newPassword;
    @NotBlank
    private String confirmNewPassword;
    @NotBlank
    private String startday;
    @NotBlank
    private String finishday;
    @NotNull
    @Valid
    private Category category;

    public ModificarCompanyData(String username, String name, @Email String mail, String phone, String address, String password,
                                String newPassword, String confirmNewPassword, String startday, String finishday, Category category) {
        this.username = username;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
        this.startday = startday;
        this.finishday = finishday;
        this.category = category;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
