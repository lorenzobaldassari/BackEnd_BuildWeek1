package Main1.entities;

import java.time.LocalDate;

public class Biglietto {
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
