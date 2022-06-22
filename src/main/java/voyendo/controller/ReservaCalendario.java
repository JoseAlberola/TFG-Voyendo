package voyendo.controller;

import java.util.Date;

public class ReservaCalendario {
    private Long id;
    private Date start;
    private Date end;
    private String title;
    private String starthour;
    private String endhour;
    private String username;
    private Long idlabour;

    public ReservaCalendario(){}

    public ReservaCalendario(Long id, Date start, Date end, String title, String starthour, String endhour, String username) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.title = title;
        this.starthour = starthour;
        this.endhour = endhour;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getIdlabour() {
        return idlabour;
    }

    public void setIdlabour(Long idlabour) {
        this.idlabour = idlabour;
    }
}