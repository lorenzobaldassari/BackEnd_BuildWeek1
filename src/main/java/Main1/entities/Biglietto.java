package Main1.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="biglietti")
public class Biglietto {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate emissione;
    private LocalDate scadenza;
    private boolean vidimazione;
    @ManyToOne
    @JoinColumn(name="biglietto_id")
    private Tipi_vendita tipi_vendita;

    @ManyToOne
    @JoinColumn(name = "mezzi_id")
    private Parco_mezzi parco_mezzi;

    public Biglietto(LocalDate emissione, LocalDate scadenza, boolean vidimazione, Tipi_vendita tipi_vendita) {
        this.emissione = emissione;
        this.scadenza = scadenza;
        this.vidimazione = vidimazione;
        this.tipi_vendita = tipi_vendita;
    }

    public Biglietto() {
    }

    public Biglietto(LocalDate emissione, LocalDate scadenza, boolean vidimazione, Tipi_vendita tipi_vendita, Parco_mezzi parco_mezzi) {
        this.emissione = emissione;
        this.scadenza = scadenza;
        this.vidimazione = vidimazione;
        this.tipi_vendita = tipi_vendita;
        this.parco_mezzi = parco_mezzi;
    }

    public Biglietto(){}

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

    public Tipi_vendita getTipi_vendita() {
        return tipi_vendita;
    }

    public void setTipi_vendita(Tipi_vendita tipi_vendita) {
        this.tipi_vendita = tipi_vendita;
    }
}
