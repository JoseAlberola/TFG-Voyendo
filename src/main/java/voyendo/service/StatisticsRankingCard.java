package voyendo.service;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class StatisticsRankingCard {
    private ArrayList<String> textoPodio;
    private ArrayList<Double> quantity;

    public StatisticsRankingCard(){}

    public StatisticsRankingCard(ArrayList<String> textoPodio, ArrayList<Double> quantity){
        this.textoPodio = textoPodio;
        this.quantity= quantity;
    }

    public ArrayList<String> getTextoPodio() {
        return textoPodio;
    }

    public void setTextoPodio(ArrayList<String> textoPodio) {
        this.textoPodio = textoPodio;
    }

    public ArrayList<Double> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Double> quantity) {
        this.quantity = quantity;
    }

    public String getQuantityString(double cantidad){
        DecimalFormat format = new DecimalFormat("0.#");
        return format.format(cantidad);
    }

    public boolean hayPrimerPuesto(){
        return textoPodio.size() > 0;
    }

    public boolean haySegundoPuesto(){
        return textoPodio.size() > 1;
    }

    public boolean hayTercerPuesto(){
        return textoPodio.size() > 2;
    }

    public String getFormatoPodio(int indexPodio){
        return indexPodio+1 + ". " + textoPodio.get(indexPodio) + " (" + getQuantityString(quantity.get(indexPodio)) + ")";
    }
}
