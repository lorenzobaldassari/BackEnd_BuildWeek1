package Main1;
import Main1.DAO.*;
import Main1.entities.*;
import Main1.entities.Enum.Condizione;
import Main1.entities.Enum.Periodicità;

import Main1.entities.Enum.Stato;

import Main1.DAO.TesseraDAO;
import Main1.DAO.UtenteDAO;
import Main1.entities.Abbonamento;
import Main1.entities.Enum.Periodicità;
import Main1.entities.Utente;
import com.github.javafaker.Faker;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.*;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        TrattaDAO trd=new TrattaDAO(em);
        Parco_mezziDAO pmd=new Parco_mezziDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        Tipi_venditaDAO tipidao= new Tipi_venditaDAO(em);
        BigliettoDao bd= new BigliettoDao(em);
        ManutenzioneDAO md=new ManutenzioneDAO(em);
        UtenteDAO ud= new UtenteDAO(em);
        TurnoDAO turDao= new TurnoDAO(em);

        // creazione mezzi

        Parco_mezzi bus1=new Bus(Stato.IN_SERVIZIO);
        Parco_mezzi bus2=new Bus(Stato.IN_SERVIZIO);
        Parco_mezzi tram1=new Tram(Stato.IN_SERVIZIO);
        Parco_mezzi tram2=new Tram(Stato.IN_MANUTENZIONE);
        Parco_mezzi tram3=new Tram(Stato.IN_SERVIZIO);

//        pmd.save(bus1);
//        pmd.save(bus2);
//        pmd.save(tram1);
//        pmd.save(tram2);
//        pmd.save(tram3);


        //creazione tratte
        Tratta tratta1= new Tratta("Milano","Roma",120);
        Tratta tratta2= new Tratta("Milano","Roma",120);
        Tratta tratta3= new Tratta("Milano","Palermo",120);

//        trd.save(tratta1);
//        trd.save(tratta2);
//        trd.save(tratta3);









        //creazione turni

        Turno turno1= new Turno(10,80);
        Turno turno2= new Turno(20,100);
        Turno turno3= new Turno(9,200);
        Turno turno4= new Turno(7,50);
        Tratta tratta1fromDb= trd.findByid(5);
        Tratta tratta2fromDb= trd.findByid(6);
        Tratta tratta3fromDb= trd.findByid(7);

        turno1.setTratta(tratta1fromDb);
        turno1.setTratta(tratta2fromDb);
        turno1.setTratta(tratta3fromDb);
        turno2.setTratta(tratta3fromDb);
        turno3.setTratta(tratta2fromDb);
//         turDao.save(turno1);
//         turDao.save(turno2);
//         turDao.save(turno3);
//         turDao.save(turno4);




        //creazione Rivenditori
        Rivenditori_autorizzati vend1= new Rivenditori_autorizzati("Roma");
        Rivenditori_autorizzati vend2= new Rivenditori_autorizzati("Milano");
        Distributore_automatico auto1 = new Distributore_automatico("Milano",Condizione.ATTIVO);
        Distributore_automatico auto2 = new Distributore_automatico("Roma",Condizione.ATTIVO);
//        tipidao.save(vend1);
//        tipidao.save(vend2);
//        tipidao.save(auto1);
//        tipidao.save(auto2);






        //creazione utenti

        // no!
        Faker faker= new Faker();
        Random random= new Random();
        Utente utente1 = new Utente(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),
                LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,30)));
        Utente utente2 = new Utente(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),
                LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,30)));
        Utente utente3 = new Utente(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),
                LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,30)));
        Utente utente4 = new Utente(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),
                LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,30)));
//        ud.save(utente1);
//        ud.save(utente2);
//        ud.save(utente3);
//        ud.save(utente4);

        //creazione abbonamenti
        //no!

        Utente utente1FromDb = ud.findUtenteById(12);
        Utente utente2FromDb = ud.findUtenteById(13);
        Utente utente3FromDb = ud.findUtenteById(14);
        Utente utente4FromDb =ud.findUtenteById(15);
        Tipi_vendita tipo1FromDb = tipidao.findByid(8);
        Tipi_vendita tipo2FromDb = tipidao.findByid(9);
        Tipi_vendita tipo3FromDb = tipidao.findByid(10);
        Tipi_vendita tipo4FromDb = tipidao.findByid(11);

        Abbonamento abbo1= new Abbonamento(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,30)),utente1FromDb,Periodicità.getRandomPeriodicità(),true,
                LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,30)),tipo1FromDb);
        Abbonamento abbo2= new Abbonamento(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,30)),utente2FromDb,Periodicità.getRandomPeriodicità(),true,
                LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,30)),tipo2FromDb);
        Abbonamento abbo3= new Abbonamento(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,30)),utente3FromDb,Periodicità.getRandomPeriodicità(),false,
                LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,30)),tipo4FromDb);

//        td.save(abbo1);
//        td.save(abbo2);
//        td.save(abbo3);


//        creazione biglietti
        //no!

//        Biglietto bigl1 = new Biglietto( LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
//                random.nextInt(1,30)),false,tipo1FromDb);
//        Biglietto bigl2 = new Biglietto( LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
//                        random.nextInt(1,30)),true ,tipo1FromDb);
//        Biglietto bigl3 = new Biglietto( LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
//                        random.nextInt(1,30)),true ,tipo2FromDb);
//        Biglietto bigl4 = new Biglietto( LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
//                random.nextInt(1,30)),true ,tipo2FromDb);

//        bd.save(bigl1);
//        bd.save(bigl2);
//        bd.save(bigl3);
//        bd.save(bigl4);

//        creazione manutenzione
        Parco_mezzi mezzo1FromDb= pmd.findById(1);
        Parco_mezzi mezzo2FromDb= pmd.findById(2);
        Parco_mezzi mezzo3FromDb= pmd.findById(3);
        Parco_mezzi mezzo4FromDb= pmd.findById(4);

        Manutenzione man1=new Manutenzione(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,28))
                ,"guasto elettrico",mezzo1FromDb);
        Manutenzione man2=new Manutenzione(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,28)),
                LocalDate.of(2023,11,28),"guasto meccanico",mezzo2FromDb);
        Manutenzione man3=new Manutenzione(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,28)),
                LocalDate.of(2023,11,28),"guasto meccanico",mezzo4FromDb);

//        md.save(man1);
//        md.save(man2);
//        md.save(man3);





        //prova metodi

//        pmd.isUnderMaintenancebyId(4);


        //biglietti emessi per punto di emissione

//        bd.numeroBigliettiEmmessi(LocalDate.of(2007,3,25),"Roma");

        //Validita di un abbonamento in base a id tessera

//        td.checkValidita("61b193fb-a52d-4af8-a30b-85f78ff13666");

        //numero di volte che un mezzo percorre una tappa

//        System.out.println(trd.NummeroDiTrattaSingolMezzo("Milano","Roma",1));

        //traccia dei periodi di servizio e manutenzione

//        md.vehicleUnderMaintenancebyId(2);

        // tenere traccia dei biglietti vidimati su un mezzo in un particoalre lasso di tempo
//         standby

        //biglietti vidimati cancellati

//        bd.deleteAllTicketEndorsed();

        //tempo effettivo di percorrenza della tratta

//        turDao.tempoEffettivoPercorrenzaTratta(30);

        //controllo se biglietto e valido e lo cancella

//        bd.checkTicketAndNull(22);


        //controlle se un abbonamento e' valido in base alla scadenza della tessera
//        td.isValidAbbonamento(LocalDate.of(2013,3,4),"61b193fb-a52d-4af8-a30b-85f78ff13666");

//        System.out.println(trd.NummeroDiTrattaSingolMezzo(5,33  ));



//            Biglietto bi= bd.findById(20);
//            Parco_mezzi mac= pmd.findById(33);
//            bd.update(20,33);





        em.close();
        emf.close();
    }
}
