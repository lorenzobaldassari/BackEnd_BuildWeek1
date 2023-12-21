package Main1.entities;

import Main1.entities.Enum.Condizione;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("distributore_automatico")
public class Distributore_automatico extends  Tipi_vendita{
    @Column(name="condizione")
    @Enumerated(EnumType.STRING)
    protected Condizione condizione;

    public Distributore_automatico(String puntoDiEmissione, Condizione condizione) {
        super(puntoDiEmissione);
        this.condizione = condizione;
    }

    public Distributore_automatico(String puntoDiEmissione, List<Biglietto> biglietti, List<Abbonamento> abbonamenti, Condizione condizione) {
        super(puntoDiEmissione, biglietti, abbonamenti);
        this.condizione = condizione;
    }

    public Distributore_automatico() {
    }

    public Distributore_automatico(String puntoDiEmissione) {
        super(puntoDiEmissione);
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
