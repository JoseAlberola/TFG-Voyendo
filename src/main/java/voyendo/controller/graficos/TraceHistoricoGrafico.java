package voyendo.controller.graficos;

import java.util.ArrayList;
import java.util.Date;

public class TraceHistoricoGrafico {
    String name;
    ArrayList<Date> fechas;
    ArrayList<Integer> valores;

    public TraceHistoricoGrafico(String name, ArrayList<Date> fechas, ArrayList<Integer> valores) {
        this.name = name;
        this.fechas = fechas;
        this.valores = valores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Date> getFechas() {
        return fechas;
    }

    public void setFechas(ArrayList<Date> fechas) {
        this.fechas = fechas;
    }

    public ArrayList<Integer> getValores() {
        return valores;
    }

    public void setValores(ArrayList<Integer> valores) {
        this.valores = valores;
    }
}