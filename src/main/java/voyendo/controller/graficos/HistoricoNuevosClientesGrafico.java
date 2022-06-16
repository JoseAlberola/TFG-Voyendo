package voyendo.controller.graficos;

import java.util.Date;

public class HistoricoNuevosClientesGrafico extends HistoricoGrafico {
    private TraceHistoricoGrafico trace;

    public HistoricoNuevosClientesGrafico() {
        super();
    }

    public HistoricoNuevosClientesGrafico(TraceHistoricoGrafico trace, Date inicioRango, Date finRango) {
        super(inicioRango, finRango);
        this.trace = trace;
    }

    public TraceHistoricoGrafico getTrace() {
        return trace;
    }

    public void setTrace(TraceHistoricoGrafico trace) {
        this.trace = trace;
    }
}
