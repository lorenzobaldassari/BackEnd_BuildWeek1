package Main1;

import Main1.DAO.TesseraDAO;
import Main1.DAO.UtenteDAO;
import Main1.entities.Abbonamento;
import Main1.entities.Enum.Periodicità;
import Main1.entities.Utente;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

//        TrattaDAO trd = new TrattaDAO(em);
//        Parco_mezziDAO pmd = new Parco_mezziDAO(em);

        // creazione mezzi
//        Parco_mezzi bus1=new Bus(Stato.IN_SEVIZIO);
//        Parco_mezzi bus2=new Bus(Stato.IN_SEVIZIO);

        //creazione tratte
//        Tratta tratta1= new Tratta("Milano","Roma",120);
//        Tratta tratta2= new Tratta("Milano","Roma",120);
//        Tratta tratta3= new Tratta("Milano","Palermo",120);

        //inserimento tratte nei mezzi
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
//        System.out.println(trd.NummeroDiTrattaSingolMezzo("Milano", "Roma", 7));


        // daos utente e tessera/abbonamento

        UtenteDAO utenteDAO = new UtenteDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);

        // faker e random per numeri e parole
        Faker faker = new Faker(Locale.ITALY);
        Random random = new Random();


        Abbonamento abbonamento = new Abbonamento(
                LocalDate.of(2023, random.nextInt(1, 12), random.nextInt(1, 30)),
                Periodicità.getRandomPeriodicità(),
                LocalDate.of(2023, random.nextInt(1, 12), random.nextInt(1, 30))
        );

        Utente utente = new Utente(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                LocalDate.of(random.nextInt(1930, 2022), random.nextInt(1, 12), random.nextInt(1, 30))
        );

        // Associa la tessera all'utente
        utente.setTessera(abbonamento);

        UUID numeroTessera = UUID.randomUUID();
        abbonamento.setNumero_tessera(numeroTessera);
        utente.setTessera(abbonamento);


        // Salvataggio
        tesseraDAO.save(abbonamento);
        utenteDAO.save(utente);



        LocalDate checkDate = LocalDate.of(2023, 7, 24);
        boolean isValid = tesseraDAO.isValidAbbonamento(checkDate, numeroTessera);
        System.out.println("L'abbonamento è valido? " + isValid);

        em.close();
        emf.close();
    }
}
