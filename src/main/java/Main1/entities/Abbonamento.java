package Main1.entities;

import Main1.entities.Enum.Periodicità;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "abbonamenti")
public class Abbonamento extends Tessera {

    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    private LocalDate data_inizio;
    private LocalDate data_fine;

    @ManyToOne
    @JoinColumn(name = "abbonamento_id")
    private Tipi_vendita tipi_vendita;

    public Abbonamento(LocalDate emissione, Periodicità periodicità, LocalDate data_inizio) {
        super(emissione);
        this.periodicità = periodicità;
        this.data_inizio = data_inizio;
        calcolaDataFine();
    }

    public void calcolaDataFine() {
        if (periodicità == Periodicità.Mensile) {
            this.data_fine = data_inizio.plusDays(30);
        } else {
            this.data_fine = data_inizio.plusDays(7);
        }
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    public LocalDate getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(LocalDate data_inizio) {
        this.data_inizio = data_inizio;
    }

    public LocalDate getData_fine() {
        return data_fine;
    }

    public void setData_fine(LocalDate data_fine) {
        this.data_fine = data_fine;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "periodicità=" + periodicità +
                ", data_inizio=" + data_inizio +
                ", data_fine=" + data_fine +
                '}';
    }
}
