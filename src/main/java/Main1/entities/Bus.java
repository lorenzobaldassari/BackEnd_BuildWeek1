package Main1.entities;

import Main1.entities.Enum.Stato;

import java.time.LocalDate;
import java.util.List;

public class Bus extends Parco_mezzi{

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
