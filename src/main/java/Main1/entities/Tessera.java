package Main1.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tessere")
public class Tessera {
    @Id
    @GeneratedValue
    private long numero_tessera;
    private LocalDate emissione;
    private LocalDate scadenza;

    @OneToOne(mappedBy = "tessere")
    private Utente utente;

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
