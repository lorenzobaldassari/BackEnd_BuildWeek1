package Main1.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tessere")
@Inheritance(strategy = InheritanceType.JOINED)
public  class Tessera {

    @Id

    private UUID numero_tessera;
    private LocalDate emissione;
    private LocalDate scadenza;

    @OneToOne
    @JoinColumn(name = "numero_tessera")
    private Utente utente;

    public Tessera() {
    }


    public Tessera(LocalDate emissione) {
        this.numero_tessera = UUID.randomUUID();
        this.emissione = emissione;
        this.scadenza = emissione.plusDays(365);
    }

    public Tessera(LocalDate emissione, Utente utente) {
        this.numero_tessera = UUID.randomUUID();
        this.emissione = emissione;
        this.scadenza = emissione.plusDays(365);
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

    public UUID getNumero_tessera() {
        return numero_tessera;
    }

    public void setNumero_tessera(UUID numero_tessera) {
        this.numero_tessera = numero_tessera;
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
