package Main1.entities;

import Main1.entities.Enum.Periodicità;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")
public class Abbonamento extends Tessera {

    private boolean validità;

    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    private LocalDate data_inizio;
    private LocalDate data_fine;

    @ManyToOne
    @JoinColumn(name="abbonamento_id")
    private Tipi_vendita tipi_vendita;


    public Abbonamento(LocalDate emissione, LocalDate scadenza, boolean validità, Periodicità periodicità, LocalDate data_inizio, LocalDate data_fine) {
        super(emissione, scadenza);
        this.validità = validità;
        this.periodicità = periodicità;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
    }


    public boolean isValidità() {
        return validità;
    }

    public void setValidità(boolean validità) {
        this.validità = validità;
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
                "validità=" + validità +
                ", periodicità=" + periodicità +
                ", data_inizio=" + data_inizio +
                ", data_fine=" + data_fine +
                '}';
    }
}
