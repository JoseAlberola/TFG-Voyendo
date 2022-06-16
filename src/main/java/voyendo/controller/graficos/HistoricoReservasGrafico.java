package voyendo.controller.graficos;

import java.util.ArrayList;
import java.util.Date;

public class HistoricoReservasGrafico extends HistoricoGrafico {
    private ArrayList<TraceHistoricoGrafico> servicios;

    public HistoricoReservasGrafico() {
        super();
    }

    public HistoricoReservasGrafico(ArrayList<TraceHistoricoGrafico> servicios, Date inicioRango, Date finRango) {
        super(inicioRango, finRango);
        this.servicios = servicios;
    }

    public ArrayList<TraceHistoricoGrafico> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<TraceHistoricoGrafico> servicios) {
        this.servicios = servicios;
    }
}
