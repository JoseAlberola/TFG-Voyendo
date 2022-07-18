package voyendo.controller.graficos;

import java.util.ArrayList;
import java.util.Date;

public class HeatMapGrafico {
    private ArrayList<Integer> semanas;
    private ArrayList<Integer> dias;
    private ArrayList<Integer> valores;
    private ArrayList<String> textos;
    private int valorMax;
    private EjeHeatMapGrafico ejeX;

    public HeatMapGrafico() {
    }

    public HeatMapGrafico(ArrayList<Integer> semanas, ArrayList<Integer> dias, ArrayList<Integer> valores,
                          ArrayList<String> textos, int valorMax, EjeHeatMapGrafico ejeX) {
        this.semanas = semanas;
        this.dias = dias;
        this.valores = valores;
        this.textos = textos;
        this.valorMax = valorMax;
        this.ejeX = ejeX;
    }

    public ArrayList<Integer> getSemanas() {
        return semanas;
    }

    public void setSemanas(ArrayList<Integer> semanas) {
        this.semanas = semanas;
    }

    public ArrayList<Integer> getDias() {
        return dias;
    }

    public void setDias(ArrayList<Integer> dias) {
        this.dias = dias;
    }

    public ArrayList<Integer> getValores() {
        return valores;
    }

    public void setValores(ArrayList<Integer> valores) {
        this.valores = valores;
    }

    public ArrayList<String> getTextos() {
        return textos;
    }

    public void setTextos(ArrayList<String> textos) {
        this.textos = textos;
    }

    public int getValorMax() {
        return valorMax;
    }

    public void setValorMax(int valorMax) {
        this.valorMax = valorMax;
    }

    public EjeHeatMapGrafico getEjeX() {
        return ejeX;
    }

    public void setEjeX(EjeHeatMapGrafico ejeX) {
        this.ejeX = ejeX;
    }
}
