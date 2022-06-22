package voyendo.controller.Data;

public class CrearAppointmentData {
    private Long idappointment;
    private String username;
    private String start;
    private String starthour;
    private Long idlabour;

    public Long getIdappointment() {
        return idappointment;
    }

    public void setIdappointment(Long idappointment) {
        this.idappointment = idappointment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStarthour() {
        return starthour;
    }

    public void setStarthour(String starthour) {
        this.starthour = starthour;
    }

    public Long getIdlabour() {
        return idlabour;
    }

    public void setIdlabour(Long idlabour) {
        this.idlabour = idlabour;
    }
}
