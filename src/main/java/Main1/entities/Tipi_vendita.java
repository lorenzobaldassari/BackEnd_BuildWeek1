package Main1.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;


public class Tipi_vendita {

    protected long id;

    protected String puntoDiEmissione;


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
