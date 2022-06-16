package voyendo.controller.graficos;

import java.util.Date;

public class HistoricoGrafico {
    protected Date inicioRango;
    protected Date finRango;

    public HistoricoGrafico() {
    }

    public HistoricoGrafico(Date inicioRango, Date finRango) {
        this.inicioRango = inicioRango;
        this.finRango = finRango;
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
