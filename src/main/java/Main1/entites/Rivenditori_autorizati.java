package Main1.entites;

public class Rivenditori_autorizati extends Tipi_vendita{

    public Rivenditori_autorizati() {
    }

    public Rivenditori_autorizati(String puntoDiEmissione) {
        super(puntoDiEmissione);
    }



    @Override
    public String toString() {
        return "Rivenditori_autorizati{" +
                "id=" + id +
                ", puntoDiEmissione='" + puntoDiEmissione + '\'' +
                '}';
    }
}
