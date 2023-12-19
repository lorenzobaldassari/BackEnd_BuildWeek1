package Main1;


import Main1.DAO.TesseraDAO;
import Main1.DAO.UtenteDAO;
import Main1.entities.Abbonamento;
import Main1.entities.Enum.Periodicità;

import Main1.DAO.Parco_mezziDAO;
import Main1.DAO.TrattaDAO;
import Main1.entities.Utente;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        TrattaDAO trd = new TrattaDAO(em);
        Parco_mezziDAO pmd = new Parco_mezziDAO(em);

        // creazione mezzi
//        Parco_mezzi bus1=new Bus(Stato.IN_SEVIZIO);
//        Parco_mezzi bus2=new Bus(Stato.IN_SEVIZIO);

        //creazione tratte
//        Tratta tratta1= new Tratta("Milano","Roma",120);
//        Tratta tratta2= new Tratta("Milano","Roma",120);
//        Tratta tratta3= new Tratta("Milano","Palermo",120);

        //inresimento tratte ni mezzi
//        bus1.insertTratta(tratta1);
//        bus2.insertTratta(tratta1);
//        bus1.insertTratta(tratta2);
//        bus1.insertTratta(tratta3);

        //salvataggio in database
//        trd.save(tratta1);
//        trd.save(tratta2);
//        trd.save(tratta3);
//        pmd.save(bus1);
//        pmd.save(bus2);

        //prova metodi

        //metodo quante volte un mezzo percorre una tratta
        System.out.println(trd.NummeroDiTrattaSingolMezzo("Milano", "Roma", 7));


        Faker faker = new Faker(Locale.ITALY);


        UtenteDAO utenteDAO = new UtenteDAO(em);
        Random randomnascita = new Random();

        Utente utente = new Utente(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), LocalDate.of(randomnascita.nextInt(1930, 2022), randomnascita.nextInt(1, 12), randomnascita.nextInt(1, 30)));


        utenteDAO.save(utente);


        TesseraDAO tesseraDAO = new TesseraDAO(em);


        Random random = new Random();
        Abbonamento abbonamento = new Abbonamento(
                LocalDate.of(2023, random.nextInt(1, 12), random.nextInt(1, 30)),
                Periodicità.getRandomPeriodicità(),
                LocalDate.of(2023, random.nextInt(1, 12), random.nextInt(1, 30))
        );

        abbonamento.calcolaDataFine();
        tesseraDAO.save(abbonamento);


        LocalDate checkDate = LocalDate.of(2023, 7, 24);
        long numeroTessera = abbonamento.getNumero_tessera();


        boolean isValid1 = tesseraDAO.isValidAbbonamento(checkDate, 1);
        boolean isValid2 = tesseraDAO.isValidAbbonamento(checkDate, 7);


        System.out.println("L'abbonamento è valido? " + isValid1);
        System.out.println("L'abbonamento è valido? " + isValid2);


        em.close();
        emf.close();
    }
}
