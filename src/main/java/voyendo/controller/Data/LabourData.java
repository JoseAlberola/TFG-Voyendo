package voyendo.controller.Data;

public class LabourData {
    private Long idlabour;
    private String name;
    private int duration;
    private double price;

    public Long getIdlabour() {
        return idlabour;
    }

    public void setIdlabour(Long idlabour) {
        this.idlabour = idlabour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
