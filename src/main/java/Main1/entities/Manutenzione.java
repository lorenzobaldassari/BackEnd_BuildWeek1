package Main1.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "manutenzione")
public class Manutenzione {
    @Id
    @GeneratedValue
    private long numero_manutenzione;
    private LocalDate giorno_inizio;
    private LocalDate giorno_stimato;
    private LocalDate giorno_fine;
    private String description;

    @ManyToOne
    @JoinColumn(name = "tipo_di_mezzo")
    private Parco_mezzi parco_mezzi;

    public Manutenzione(LocalDate giorno_inizio, LocalDate giorno_fine, String description) {
        this.giorno_inizio = giorno_inizio;
        this.giorno_stimato = giorno_inizio.plusDays(7);
        this.giorno_fine = giorno_fine;
        this.description = description;
    }

    public Manutenzione(){
    }

    public Manutenzione(LocalDate giorno_inizio,LocalDate giorno_fine, String description, Parco_mezzi parco_mezzi) {
        this.giorno_inizio = giorno_inizio;
        this.giorno_stimato = giorno_inizio.plusDays(7);
        this.giorno_fine = giorno_fine;
        this.description = description;
        this.parco_mezzi = parco_mezzi;
    }

    public long getNumero_manutenzione() {
        return numero_manutenzione;
    }

    public LocalDate getGiorno_inizio() {
        return giorno_inizio;
    }

    public void setGiorno_inizio(LocalDate giorno_inizio) {
        this.giorno_inizio = giorno_inizio;
    }

    public LocalDate getGiorno_stimato() {
        return giorno_stimato;
    }

    public void setGiorno_stimato(LocalDate giorno_stimato) {
        this.giorno_stimato = giorno_stimato;
    }

    public LocalDate getGiorno_fine() {
        return giorno_fine;
    }

    public void setGiorno_fine(LocalDate giorno_fine) {
        this.giorno_fine = giorno_fine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Parco_mezzi getParco_mezzi() {
        return parco_mezzi;
    }

    public void setParco_mezzi(Parco_mezzi parco_mezzi) {
        this.parco_mezzi = parco_mezzi;
    }



    @Override
    public String toString() {
        return "Manutenzione{" +
                "numero_manutenzione=" + numero_manutenzione +
                ", giorno_inizio=" + giorno_inizio +
                ", giorno_stimato=" + giorno_stimato +
                ", giorno_fine=" + giorno_fine +
                ", description='" + description + '\'' +
                '}';
    }
}
