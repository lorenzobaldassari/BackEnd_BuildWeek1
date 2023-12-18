package Main1.entities;

public class Distributore_automatico extends  Tipi_vendita{

    protected Condizione condizione;

    public Distributore_automatico(String puntoDiEmissione, Condizione condizione) {
        super(puntoDiEmissione);
        this.condizione = condizione;
    }

    public Condizione getCondizione() {
        return condizione;
    }

    public void setCondizione(Condizione condizione) {
        this.condizione = condizione;
    }

    @Override
    public String toString() {
        return "Distributore_automatico{" +
                "condizione=" + condizione +
                ", id=" + id +
                ", puntoDiEmissione='" + puntoDiEmissione + '\'' +
                '}';
    }
}
