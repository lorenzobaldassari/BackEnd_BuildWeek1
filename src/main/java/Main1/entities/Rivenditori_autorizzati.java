package Main1.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("rivenditori_autorizzati")
public class Rivenditori_autorizzati extends Tipi_vendita{

    public Rivenditori_autorizzati() {
    }

    public Rivenditori_autorizzati(String puntoDiEmissione) {
        super(puntoDiEmissione);
    }



    @Override
    public String toString() {
        return "Rivenditori_autorizati{" +
                "id=" + id +
                ", puntoDiEmissione='" + puntoDiEmissione + '\'' +
                '}';
    }
}
