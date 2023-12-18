package Main1.entities;

import java.time.LocalDate;

public class Abbonamento extends Tessera {

    private boolean validità;
    private Periodicità periodicità;

    private LocalDate data_inizio;
    private LocalDate data_fine;


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


}
