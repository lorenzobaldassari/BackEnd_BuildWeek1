package Main1.entities;

import Main1.entities.Enum.Stato;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;
@Entity
@DiscriminatorValue("bus")
public class Bus extends Parco_mezzi{
    @Column(name="capienza")
    protected long capienza;

    public Bus(Stato stato, List<LocalDate> giorniDiServizio, List<LocalDate> giorniDiManutenzione) {
        super(stato, giorniDiServizio, giorniDiManutenzione);
        this.capienza = 50;
    }

    public Bus(Stato stato) {
        super(stato);
        this.capienza = 50;
    }

    public long getCapienza() {
        return capienza;
    }

    public Bus() {
    }

    @Override
    public String toString() {
        return "Tram{" +
                "capienza=" + capienza +
                ", id=" + id +
                ", stato=" + stato +
                ", giorniDiServizio=" + giorniDiServizio +
                ", giorniDiManutenzione=" + giorniDiManutenzione +
                '}';
    }
}
