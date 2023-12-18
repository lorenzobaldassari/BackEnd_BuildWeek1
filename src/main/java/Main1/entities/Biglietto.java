package Main1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Biglietto {

    @Id
    @GeneratedValue
    private long id;
    private LocalDate emissione;
    private LocalDate scadenza;
    private boolean vidimazione;

    public Biglietto(LocalDate emissione, LocalDate scadenza, boolean vidimazione) {
        this.emissione = emissione;
        this.scadenza = scadenza;
        this.vidimazione = vidimazione;
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public void setEmissione(LocalDate emissione) {
        this.emissione = emissione;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public boolean isVidimazione() {
        return vidimazione;
    }

    public void setVidimazione(boolean vidimazione) {
        this.vidimazione = vidimazione;
    }

    public long getId() {
        return id;
    }
}
