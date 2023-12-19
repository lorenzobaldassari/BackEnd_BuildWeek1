package Main1.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tessere")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tessera {
    @Id
    @GeneratedValue
    private long numero_tessera;
    private LocalDate emissione;
    private LocalDate scadenza;

    @OneToOne(mappedBy = "tessera")
    private Utente utente;

    public Tessera() {
    }

    public Tessera(LocalDate emissione) {
        this.emissione = emissione;
        this.scadenza = emissione.plusDays(365);
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "numero_tessera=" + numero_tessera +
                ", emissione=" + emissione +
                ", scadenza=" + scadenza +
                ", utente=" + utente +
                '}';
    }
}
