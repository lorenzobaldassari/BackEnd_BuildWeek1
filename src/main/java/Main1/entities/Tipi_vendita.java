package Main1.entities;


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
