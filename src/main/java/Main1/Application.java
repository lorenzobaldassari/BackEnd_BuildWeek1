package Main1;


import Main1.DAO.*;
import Main1.entities.*;
import Main1.entities.Enum.Condizione;
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
        TesseraDAO td = new TesseraDAO(em);
        Tipi_venditaDAO tipidao= new Tipi_venditaDAO(em);
        BigliettoDao bd= new BigliettoDao(em);
        // creazione mezzi
        Parco_mezzi bus1=new Bus(Stato.IN_SEVIZIO);
        Parco_mezzi bus2=new Bus(Stato.IN_SEVIZIO);
/*

        //creazione tratte
        Tratta tratta1= new Tratta("Milano","Roma",120);
        Tratta tratta2= new Tratta("Milano","Roma",120);
        Tratta tratta3= new Tratta("Milano","Palermo",120);


        //inresimento tratte ni mezzi
        bus1.insertTratta(tratta1);
        bus2.insertTratta(tratta1);
        bus1.insertTratta(tratta2);
        bus1.insertTratta(tratta3);

        //salvataggio in database
        trd.save(tratta1);
        trd.save(tratta2);
        trd.save(tratta3);
        pmd.save(bus1);
        pmd.save(bus2);
*/

        //creazione Rivenditori
        Rivenditori_autorizzati vend1= new Rivenditori_autorizzati("Roma");
        Rivenditori_autorizzati vend2= new Rivenditori_autorizzati("Milano");
        Distributore_automatico auto1 = new Distributore_automatico("Milano",Condizione.ATTIVO);
        Distributore_automatico auto2 = new Distributore_automatico("Roma",Condizione.ATTIVO);
//        tipidao.save(vend1);
//        tipidao.save(vend2);
//        tipidao.save(auto1);
//        tipidao.save(auto2);

        //creazione Biglietti
       Tipi_vendita fixedFromDb= tipidao.findByid(1);
       Tipi_vendita autoFromDb= tipidao.findByid(3);

    /*    //metodo quante volte un mezzo percorre una tratta
        System.out.println(trd.NummeroDiTrattaSingolMezzo("Milano","Roma",7));

        TesseraDAO elemento = new TesseraDAO(em);

        Biglietto bigl1= new Biglietto(LocalDate.now(),LocalDate.now(),true,fixedFromDb);
        Biglietto bigl2= new Biglietto(LocalDate.now(),LocalDate.now(),true,fixedFromDb);
        Biglietto bigl3= new Biglietto(LocalDate.now(),LocalDate.now(),true,fixedFromDb);
        Biglietto bigl4= new Biglietto(LocalDate.now(),LocalDate.now(),true,autoFromDb);
        Biglietto bigl5= new Biglietto(LocalDate.now(),LocalDate.now(),true,autoFromDb);
        Biglietto bigl6= new Biglietto(LocalDate.now(),LocalDate.now(),true,autoFromDb);
//        bd.save(bigl1);
//        bd.save(bigl2);
//        bd.save(bigl3);
//        bd.save(bigl4);
//        bd.save(bigl5);
//        bd.save(bigl6);
//        creazione abbonamenti


        Abbonamento abbonamento1 = new Abbonamento(
                LocalDate.of(2023, 10, 16),
                true,
                Periodicità.Mensile,
                LocalDate.of(2023, 10, 16)
        );
        Abbonamento abbonamento2 = new Abbonamento(
                LocalDate.of(2023, 10, 16),
                false,
                Periodicità.Mensile,
                LocalDate.of(2023, 10, 16)
        );

        //inserimento tratte ni mezzi
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
//        td.save(abbonamento1);
//        td.save(abbonamento2);
//        td.checkValidita(1);
//        td.checkValidita(2);
        //prova metodi

        //metodo quante volte un mezzo percorre una tratta
//        System.out.println(trd.NummeroDiTrattaSingolMezzo("Milano","Roma",7));





//        abbonamento1.calcolaDataFine();
//        elemento.save(abbonamento1);*/

        //creazione biglietti
        BigliettoDao bgDao = new BigliettoDao(em);
        Tipi_venditaDAO tvDao = new Tipi_venditaDAO(em);

        Distributore_automatico tipo = new Distributore_automatico("Milano", Condizione.ATTIVO);
        tvDao.save(tipo);
        Tipi_vendita id = tvDao.findByid(16);
        Parco_mezzi b1 = pmd.findById(2);
        Parco_mezzi b2 = pmd.findById(6);
        Biglietto bg1 = new Biglietto(LocalDate.of(2023, 12, 19), LocalDate.of(2023, 12, 19), true,id, b1);
        Biglietto bg2 = new Biglietto(LocalDate.now(), LocalDate.of(2023, 12, 19), true,id, b2);
        //bgDao.save(bg1);
        //bgDao.save(bg2);
        long num = bgDao.numeroBigliettiEmmessi(LocalDate.of(2023, 12, 19), "Roma");

        System.out.println(num);

        bd.numeroDiBigliettoPerPeriodoEDistributore(LocalDate.now(),"Rivenditori_autorizzati");

        em.close();
        emf.close();
    }
}
