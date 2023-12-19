package Main1;

import Main1.DAO.TesseraDAO;
import Main1.entities.Abbonamento;
import Main1.entities.Enum.Periodicità;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        System.out.println("Hello World1!");

        TesseraDAO elemento = new TesseraDAO(em);

        Abbonamento abbonamento1 = new Abbonamento(
                LocalDate.of(2023, 10, 16),
                true,
                Periodicità.Mensile,
                LocalDate.of(2023, 10, 16)
        );

        abbonamento1.calcolaDataFine();
        elemento.save(abbonamento1);

        em.close();
        emf.close();
    }
}
