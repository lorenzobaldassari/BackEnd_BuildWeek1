package Main1.entities;

public class Tratta {

    private long id;

    private String zona_partenza;
    private String capolinea;
    private int tempoPercoreenzaInMinuti;



    public Tratta(String zona_partenza, String capolinea, int tempoPercoreenzaInMinuti) {
        this.zona_partenza = zona_partenza;
        this.capolinea = capolinea;
        this.tempoPercoreenzaInMinuti = tempoPercoreenzaInMinuti;
    }

    public Tratta() {
    }

    public void setZona_partenza(String zona_partenza) {
        this.zona_partenza = zona_partenza;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public void setTempoPercoreenzaInMinuti(int tempoPercoreenzaInMinuti) {
        this.tempoPercoreenzaInMinuti = tempoPercoreenzaInMinuti;
    }

    public long getId() {
        return id;
    }

    public String getZona_partenza() {
        return zona_partenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public int getTempoPercoreenzaInMinuti() {
        return tempoPercoreenzaInMinuti;
    }



    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", zona_partenza='" + zona_partenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempoPercoreenzaInMinuti=" + tempoPercoreenzaInMinuti +
                '}';
    }
}
