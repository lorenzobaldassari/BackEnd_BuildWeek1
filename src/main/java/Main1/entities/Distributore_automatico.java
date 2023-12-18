package Main1.entities;

import Main1.entities.Enum.Condizione;

import javax.persistence.*;

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
