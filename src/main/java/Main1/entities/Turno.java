package Main1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turni")
public class Turno {

    @Id
    @GeneratedValue
    private long id;
    private int inizio_servizio;
    private int tempo_effettivo_percorrenza;

    @ManyToMany
    @JoinTable(name="turno_tratta",joinColumns =@JoinColumn(name="turno_id"),
            inverseJoinColumns = @JoinColumn(name="tratta_id"))
    private List<Tratta> tratta= new ArrayList<>();

    public Turno (){}

    public Turno(int inizio_servizio, int tempo_effettivo_percorrenza) {
        this.inizio_servizio = inizio_servizio;
        this.tempo_effettivo_percorrenza = tempo_effettivo_percorrenza;
    }

    public long getId() {
        return id;
    }

    public int getInizio_servizio() {
        return inizio_servizio;
    }

    public void setInizio_servizio(int inizio_servizio) {
        this.inizio_servizio = inizio_servizio;
    }

    public int getTempo_effettivo_percorrenza() {
        return tempo_effettivo_percorrenza;
    }

    public void setTempo_effettivo_percorrenza(int tempo_effettivo_percorrenza) {
        this.tempo_effettivo_percorrenza = tempo_effettivo_percorrenza;
    }

    public List<Tratta> getTratta() {
        return tratta;
    }

    public void setTratta(Tratta Tratta) {
        this.tratta.add(Tratta);
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", inizio_servizio=" + inizio_servizio +
                ", tempo_effettivo_percorrenza=" + tempo_effettivo_percorrenza +
                ", tratta=" + tratta +
                '}';
    }
}
