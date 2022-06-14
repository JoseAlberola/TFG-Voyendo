package voyendo.controller.graficos;

import java.util.ArrayList;
import java.util.Date;

public class HistoricoReservasGrafico {
    private ArrayList<TraceHistoricoReservasGrafico> servicios;
    private Date inicioRango;
    private Date finRango;

    public HistoricoReservasGrafico() {
    }

    public HistoricoReservasGrafico(ArrayList<TraceHistoricoReservasGrafico> servicios, Date inicioRango, Date finRango) {
        this.servicios = servicios;
        this.inicioRango = inicioRango;
        this.finRango = finRango;
    }

    public ArrayList<TraceHistoricoReservasGrafico> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<TraceHistoricoReservasGrafico> servicios) {
        this.servicios = servicios;
    }

    public Date getInicioRango() {
        return inicioRango;
    }

    public void setInicioRango(Date inicioRango) {
        this.inicioRango = inicioRango;
    }

    public Date getFinRango() {
        return finRango;
    }

    public void setFinRango(Date finRango) {
        this.finRango = finRango;
    }
}
