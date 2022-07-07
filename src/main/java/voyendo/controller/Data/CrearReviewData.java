package voyendo.controller.Data;

public class CrearReviewData {
    private Long idreview;
    private String comentario;
    private int valuation;

    public Long getIdreview() {
        return idreview;
    }

    public void setIdreview(Long idreview) {
        this.idreview = idreview;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValuation() {
        return valuation;
    }

    public void setValuation(int valuation) {
        this.valuation = valuation;
    }
}
