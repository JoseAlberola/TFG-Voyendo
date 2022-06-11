package voyendo.service;

import java.text.DecimalFormat;

public class StatisticsCard {
    private double quantity;
    private double percentage;
    private String color;

    public StatisticsCard(){}

    public StatisticsCard(double quantity, double percentage, String color){
        this.quantity = quantity;
        this.percentage = percentage;
        this.color = color;
    }

    public boolean isGreen(){
        if(color.equals("green")){
            return true;
        }
        return false;
    }

    public String getQuantityString(){
        DecimalFormat format = new DecimalFormat("0.#");
        return format.format(quantity);
    }

    public String getPercentageString(){
        DecimalFormat format = new DecimalFormat("0.#");
        return format.format(percentage);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
