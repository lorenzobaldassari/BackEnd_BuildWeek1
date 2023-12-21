package Main1.entities;

import Main1.entities.Enum.Stato;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_di_mezzo")

public abstract class Parco_mezzi {
@Id
@GeneratedValue
    protected long id;
    @Column(name="stato")
    @Enumerated(EnumType.STRING)
    protected Stato stato;
    @ManyToMany
    @JoinTable(name="mezzi_tratta",joinColumns =@JoinColumn(name="mezzi_id"),
    inverseJoinColumns = @JoinColumn(name="tratta_id"))
    private List<Tratta> tratte=new ArrayList<>();
    @OneToMany(mappedBy = "parco_mezzi")
    private List<Manutenzione> manutenzioni;

    @OneToMany(mappedBy = "parco_mezzi")
    private List<Biglietto> biglietto;

    public Parco_mezzi() {
    }

    public Parco_mezzi(Stato stato, List<Tratta> tratte, List<Manutenzione> manutenzioni, List<Biglietto> biglietto) {
        this.stato = stato;
        this.tratte = tratte;
        this.manutenzioni = manutenzioni;
        this.biglietto = biglietto;
    }

    public Parco_mezzi(Stato stato) {
        this.stato = stato;
    }



    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public long getId() {
        return id;
    }



    public Stato getStato() {
        return stato;
    }
    public void insertTratta( Tratta tratta) {
        this.tratte.add(tratta);
    }

    public List<Tratta> getTratte() {
        return tratte;
    }

    public void setTratte(List<Tratta> tratte) {
        this.tratte = tratte;
    }

    public List<Manutenzione> getManutenzioni() {
        return manutenzioni;
    }

    public void setManutenzioni(List<Manutenzione> manutenzioni) {
        this.manutenzioni = manutenzioni;
    }

    @Override
    public String toString() {
        return "Parco_mezzi{" +
                "id=" + id +
                ", stato=" + stato +
                ", tratte=" + tratte +
                '}';
    }
}
