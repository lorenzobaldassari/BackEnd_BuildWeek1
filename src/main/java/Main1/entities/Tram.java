package Main1.entities;

import Main1.entities.Enum.Stato;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;
@Entity
@DiscriminatorValue("tram")
public class Tram extends Parco_mezzi{
    @Column(name="capienza")
    protected long capienza;

    public Tram(Stato stato, long capienza) {
        super(stato);
        this.capienza = capienza;
    }

    public Tram(Stato stato) {
        super(stato);
        this.capienza = 30;
    }

    public long getCapienza() {
        return capienza;
    }

    public Tram() {
    }

    @Override
    public String toString() {
        return "Tram{" +
                "capienza=" + capienza +
                ", id=" + id +
                ", stato=" + stato +
                '}';
    }
}
