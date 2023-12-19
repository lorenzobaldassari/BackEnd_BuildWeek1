package Main1;


import Main1.DAO.*;
import Main1.entities.*;
import Main1.entities.Enum.Periodicità;
import Main1.entities.Enum.Stato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        TrattaDAO trd=new TrattaDAO(em);
        Parco_mezziDAO pmd=new Parco_mezziDAO(em);
        BigliettoDao bd=new BigliettoDao(em);
        ManutenzioneDAO md=new ManutenzioneDAO(em);
        // creazione mezzi
//        Parco_mezzi bus1=new Bus(Stato.IN_SEVIZIO);
//        Parco_mezzi bus2=new Bus(Stato.IN_SEVIZIO);
          Parco_mezzi tram1=new Tram(Stato.IN_SEVIZIO);

        //creazione tratte
//        Tratta tratta1= new Tratta("Milano","Roma",120);
//        Tratta tratta2= new Tratta("Milano","Roma",120);
//        Tratta tratta3= new Tratta("Milano","Palermo",120);

        //creazione biglietti
        //Biglietto ticket1=new Biglietto(LocalDate.of(2023,12,10),LocalDate.now(),true);
        //Biglietto ticket2=new Biglietto(LocalDate.of(2023,12,10),LocalDate.now(),false);
        //creazione manutenzione
        Manutenzione man1=new Manutenzione(LocalDate.of(2023,11,18),LocalDate.of(2023,11,28),"guasto elettrico",tram1);
        Manutenzione man2=new Manutenzione(LocalDate.of(2023,11,18),LocalDate.of(2023,11,28),"guasto meccanico",tram1);


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
          //pmd.save(tram1);
          //bd.save(ticket1);
//        bd.save(ticket2);
          //md.save(man1);
          // md.save(man2);

        //prova metodi

        //metodo quante volte un mezzo percorre una tratta
       // System.out.println(trd.NummeroDiTrattaSingolMezzo("Milano","Roma",7));

        TesseraDAO elemento = new TesseraDAO(em);

        Abbonamento abbonamento1 = new Abbonamento(
                LocalDate.of(2023, 10, 16),
                true,
                Periodicità.Mensile,
                LocalDate.of(2023, 10, 16)
        );

//        abbonamento1.calcolaDataFine();
//        elemento.save(abbonamento1);
     // bd.checkTicketAndNull(2);
        // bd.deleteAllTicketEndorsed();

        md.vehicleUnderMaintenancebyId(9);


        em.close();
        emf.close();
    }
}
