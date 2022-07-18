package voyendo.controller.graficos;

import java.util.ArrayList;
import java.util.Date;

public class HistoricoIngresosGrafico extends HistoricoGrafico {
    private ArrayList<TraceHistoricoGrafico> traces;

    public HistoricoIngresosGrafico() {
        super();
    }

    public HistoricoIngresosGrafico(ArrayList<TraceHistoricoGrafico> traces, Date inicioRango, Date finRango) {
        super(inicioRango, finRango);
        this.traces = traces;
    }

    public ArrayList<TraceHistoricoGrafico> getTraces() {
        return traces;
    }

    public void setTraces(ArrayList<TraceHistoricoGrafico> traces) {
        this.traces = traces;
    }
}
