package Main1.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipologia_venditore")
public abstract class Tipi_vendita {
    @Id
    @GeneratedValue
    protected long id;



    @Column(name="punto_di_emissione")
    protected String puntoDiEmissione;

    @OneToMany(mappedBy = "tipi_vendita")
    private List<Biglietto> biglietti;
    @OneToMany(mappedBy = "tipi_vendita")
    private List<Abbonamento> abbonamenti;





    public Tipi_vendita() {
    }



    public Tipi_vendita(String puntoDiEmissione) {
        this.puntoDiEmissione = puntoDiEmissione;
    }

    public long getId() {
        return id;
    }

    public String getPuntoDiEmissione() {
        return puntoDiEmissione;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public void setBiglietti(List<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }

    public void setAbbonamenti(List<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }

    public void setPuntoDiEmissione(String puntoDiEmissione) {
        this.puntoDiEmissione = puntoDiEmissione;
    }

    @Override
    public String toString() {
        return "Tipi_vendita{" +
                "id=" + id +
                ", puntoDiEmissione='" + puntoDiEmissione + '\'' +
                '}';
    }
}
