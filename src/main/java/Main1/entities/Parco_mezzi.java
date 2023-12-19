package Main1.entities;

import Main1.entities.Enum.Stato;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="tipo_di_mezzo")
public abstract class Parco_mezzi {
@Id
@GeneratedValue
    protected long id;
    @Column(name="stato")
    @Enumerated(EnumType.STRING)
    protected Stato stato;
    @Transient
    protected List<LocalDate> giorniDiServizio;
    @Transient
    protected List<LocalDate> giorniDiManutenzione;
    @ManyToMany
    @JoinTable(name="mezzi_tratta",joinColumns =@JoinColumn(name="mezzi_id"),
    inverseJoinColumns = @JoinColumn(name="tratta_id"))
    private List<Tratta> tratte;

    public Parco_mezzi() {
    }

    public Parco_mezzi(Stato stato, List<LocalDate> giorniDiServizio, List<LocalDate> giorniDiManutenzione) {
        this.stato = stato;
        this.giorniDiServizio = giorniDiServizio;
        this.giorniDiManutenzione = giorniDiManutenzione;
    }

    public Parco_mezzi(Stato stato) {
        this.stato = stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setGiorniDiServizio(LocalDate giorniDiServizio) {
        this.giorniDiServizio.add(giorniDiServizio);
    }

    public void setGiorniDiManutenzione(LocalDate giorniDiManutenzione) {
        this.giorniDiManutenzione.add(giorniDiManutenzione);
    }

    public long getId() {
        return id;
    }

    public Stato getStato() {
        return stato;
    }

    public List<LocalDate> getGiorniDiServizio() {
        return giorniDiServizio;
    }

    public List<LocalDate> getGiorniDiManutenzione() {
        return giorniDiManutenzione;
    }

    public List<Tratta> getTratte() {
        return tratte;
    }

    public void setTratte(List<Tratta> tratte) {
        this.tratte = tratte;
    }

    @Override
    public String toString() {
        return "Parco_mezzi{" +
                "id=" + id +
                ", stato=" + stato +
                ", giorniDiServizio=" + giorniDiServizio +
                ", giorniDiManutenzione=" + giorniDiManutenzione +
                '}';
    }
}
