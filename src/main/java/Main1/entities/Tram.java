package Main1.entities;

import java.time.LocalDate;
import java.util.List;

public class Tram extends Parco_mezzi{

    protected long capienza;

    public Tram(Stato stato, List<LocalDate> giorniDiServizio, List<LocalDate> giorniDiManutenzione) {
        super(stato, giorniDiServizio, giorniDiManutenzione);
        this.capienza = 30;
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
                ", giorniDiServizio=" + giorniDiServizio +
                ", giorniDiManutenzione=" + giorniDiManutenzione +
                '}';
    }
}
