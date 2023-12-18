package Main1.entities;

import java.time.LocalDate;

public class Tessera {
    private long numero_tessera;
    private LocalDate emissione;
    private LocalDate scadenza;

    public Tessera() {
    }

    public Tessera(LocalDate emissione, LocalDate scadenza) {

        this.emissione = emissione;
        this.scadenza = scadenza;
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public long getNumero_tessera() {
        return numero_tessera;
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
}
