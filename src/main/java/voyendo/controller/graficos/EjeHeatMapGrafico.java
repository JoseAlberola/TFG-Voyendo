package voyendo.controller.graficos;

import java.util.ArrayList;

public class EjeHeatMapGrafico {
    ArrayList<String> tickText;
    ArrayList<Integer> tickVals;

    public EjeHeatMapGrafico(ArrayList<String> tickText, ArrayList<Integer> tickVals) {
        this.tickText = tickText;
        this.tickVals = tickVals;
    }

    public ArrayList<String> getTickText() {
        return tickText;
    }

    public void setTickText(ArrayList<String> tickText) {
        this.tickText = tickText;
    }

    public ArrayList<Integer> getTickVals() {
        return tickVals;
    }

    public void setTickVals(ArrayList<Integer> tickVals) {
        this.tickVals = tickVals;
    }
}