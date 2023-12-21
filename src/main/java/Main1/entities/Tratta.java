package Main1.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="tratta")
public class Tratta {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="zona_partenza")
    private String zona_partenza;
    @Column(name="capolinea")
    private String capolinea;

    @Column(name="tempo_percorso_in_minuti")
    private int tempoPercoreenzaInMinuti;

    @ManyToMany
    @JoinTable(name="mezzi_tratta",joinColumns =@JoinColumn(name="tratta_id"),
            inverseJoinColumns = @JoinColumn(name="mezzi_id"))
    private List<Parco_mezzi> mezzi;

    @ManyToMany
    @JoinTable(name="turno_tratta",joinColumns =@JoinColumn(name="tratta_id"),
            inverseJoinColumns = @JoinColumn(name="turno_id"))
    private List<Turno> turni;



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

    public List<Parco_mezzi> getMezzi() {
        return mezzi;
    }

    public void setMezzi(List<Parco_mezzi> mezzi) {
        this.mezzi = mezzi;
    }

    public List<Turno> getTurni() {
        return turni;
    }

    public void setTurni(List<Turno> turni) {
        this.turni = turni;
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
