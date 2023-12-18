package Main1.entites;

import Main1.entites.Enum.Stato;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

public abstract class Parco_mezzi {

    protected long id;

    protected Stato stato;

    protected List<LocalDate> giorniDiServizio;
    protected List<LocalDate> giorniDiManutenzione;

    public Parco_mezzi() {
    }

    public Parco_mezzi(Stato stato, List<LocalDate> giorniDiServizio, List<LocalDate> giorniDiManutenzione) {
        this.stato = stato;
        this.giorniDiServizio = giorniDiServizio;
        this.giorniDiManutenzione = giorniDiManutenzione;
    }

    public Parco_mezzi(Stato stato) {
        this.stato = stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setGiorniDiServizio(LocalDate giorniDiServizio) {
        this.giorniDiServizio.add(giorniDiServizio);
    }

    public void setGiorniDiManutenzione(LocalDate giorniDiManutenzione) {
        this.giorniDiManutenzione.add(giorniDiManutenzione);
    }

    public long getId() {
        return id;
    }

    public Stato getStato() {
        return stato;
    }

    public List<LocalDate> getGiorniDiServizio() {
        return giorniDiServizio;
    }

    public List<LocalDate> getGiorniDiManutenzione() {
        return giorniDiManutenzione;
    }

    @Override
    public String toString() {
        return "Parco_mezzi{" +
                "id=" + id +
                ", stato=" + stato +
                ", giorniDiServizio=" + giorniDiServizio +
                ", giorniDiManutenzione=" + giorniDiManutenzione +
                '}';
    }
}
