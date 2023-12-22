package Main1;
import Main1.DAO.*;
import Main1.entities.*;
import Main1.entities.Enum.Condizione;
import Main1.entities.Enum.Periodicità;

import Main1.entities.Enum.Stato;

import Main1.DAO.TesseraDAO;
import Main1.DAO.UtenteDAO;
import Main1.entities.Abbonamento;

import Main1.entities.Utente;
import com.github.javafaker.Faker;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.*;


public class Application {
    static Scanner input = new Scanner(System.in);
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        TrattaDAO trd=new TrattaDAO(em);
        Parco_mezziDAO pmd=new Parco_mezziDAO(em);
        Tipi_venditaDAO tipidao= new Tipi_venditaDAO(em);
        BigliettoDao bd = new BigliettoDao(em);
        ManutenzioneDAO md=new ManutenzioneDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        TurnoDAO turDao = new TurnoDAO(em);
        TesseraDAO td = new TesseraDAO(em);


        // creazione mezzi

        Parco_mezzi bus1=new Bus(Stato.IN_SERVIZIO);
        Parco_mezzi bus2=new Bus(Stato.IN_SERVIZIO);
        Parco_mezzi tram1=new Tram(Stato.IN_SERVIZIO);
        Parco_mezzi tram2=new Tram(Stato.IN_MANUTENZIONE);

    /*   pmd.save(bus1);
       pmd.save(bus2);
       pmd.save(tram1);
       pmd.save(tram2);*/

        Parco_mezzi tram3=new Tram(Stato.IN_SERVIZIO);

//
//        pmd.save(bus1);
//        pmd.save(bus2);
//        pmd.save(tram1);
//        pmd.save(tram2);
//        pmd.save(tram3);



        //creazione tratte

        Tratta tratta1= new Tratta("Milano","Roma",120);
        Tratta tratta2= new Tratta("Milano","Roma",120);
        Tratta tratta3= new Tratta("Milano","Palermo",120);
        /*trd.save(tratta1);
        trd.save(tratta2);
        trd.save(tratta3);
*/



        //creazione turni

        Turno turno1= new Turno(10,80);
        Turno turno2= new Turno(20,100);
        Turno turno3= new Turno(9,200);
        Turno turno4= new Turno(7,50);


      /*  bus1.insertTratta(tratta1);
        bus2.insertTratta(tratta1);
        bus1.insertTratta(tratta2);
        bus1.insertTratta(tratta3);
        Tratta tratta1FromDb= trd.findByid(5);
        tram3.insertTratta(tratta1FromDb);
        tram3.insertTratta(tratta1FromDb);
        tram3.insertTratta(tratta1FromDb);
        tram3.insertTratta(tratta1FromDb);
        pmd.save(bus1);
        pmd.save(bus2);
        pmd.save(tram1);
        pmd.save(tram2);
        pmd.save(tram3);*/



        //creazione Rivenditori
        Rivenditori_autorizzati vend1= new Rivenditori_autorizzati("Roma");
        Rivenditori_autorizzati vend2= new Rivenditori_autorizzati("Milano");
        Distributore_automatico auto1 = new Distributore_automatico("Milano",Condizione.ATTIVO);
        Distributore_automatico auto2 = new Distributore_automatico("Roma",Condizione.ATTIVO);
/*

       tipidao.save(vend1);
        tipidao.save(vend2);
        tipidao.save(auto1);
        tipidao.save(auto2);
*/



        Tipi_vendita tipo1FromDb = tipidao.findByid(8);
        Tipi_vendita tipo2FromDb = tipidao.findByid(9);
        Tipi_vendita tipo3FromDb = tipidao.findByid(10);
        Tipi_vendita tipo4FromDb = tipidao.findByid(11);

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

        //creazione abbonamenti


        Abbonamento abbo1= new Abbonamento(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,28)),Periodicità.getRandomPeriodicità(),
                LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,28)));

        Abbonamento abbo2= new Abbonamento(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,30)),Periodicità.getRandomPeriodicità(),
                LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,28)));

        Abbonamento abbo3= new Abbonamento(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,30)),Periodicità.getRandomPeriodicità(),
                LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,28)));


        // creazione biglietti
        Biglietto bg1 = new Biglietto(LocalDate.now(), tipo1FromDb);
        Biglietto bg2 = new Biglietto(LocalDate.now(), tipo2FromDb);
        Biglietto bg3 = new Biglietto(LocalDate.now(), tipo3FromDb);
        Biglietto bg4 = new Biglietto(LocalDate.now(), tipo4FromDb);
       /* dg.save(bg1);
        dg.save(bg2);
        dg.save(bg3);
        dg.save(bg4);*/

        Biglietto bigl1 = new Biglietto( LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,30)));
        Biglietto bigl2 = new Biglietto( LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,30)));
        Biglietto bigl3 = new Biglietto( LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                        random.nextInt(1,30)));
        Biglietto bigl4 = new Biglietto( LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,30)));



//        creazione manutenzione

        Manutenzione man1=new Manutenzione(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,28))
                ,"guasto elettrico");
        Manutenzione man2=new Manutenzione(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,28)),
                LocalDate.of(2023,11,28),"guasto meccanico");
        Manutenzione man3=new Manutenzione(LocalDate.of(random.nextInt(1990,2022),random.nextInt(1,12),
                random.nextInt(1,28)),
                LocalDate.of(2023,11,28),"guasto meccanico");

/*
        md.save(man1);
        md.save(man2);
        md.save(man3);
        bd.save(bigl1);
        bd.save(bigl2);
        bd.save(bigl3);
        bd.save(bigl4);
        td.save(abbo1);
        td.save(abbo2);
        td.save(abbo3);
        ud.save(utente1);
        ud.save(utente2);
        ud.save(utente3);
        ud.save(utente4);
        turDao.save(turno1);
        turDao.save(turno2);
        turDao.save(turno3);
        turDao.save(turno4);
        trd.save(tratta1);
        trd.save(tratta2);
        trd.save(tratta3);
        pmd.save(bus1);
        pmd.save(bus2);
        pmd.save(tram1);
        pmd.save(tram2);
        pmd.save(tram3);*/
/*
        bd.updateTipoDiVenditore(4, 24);
        bd.updateTipoDiVenditore(5, 25);
        bd.updateTipoDiVenditore(5, 26);*/

        /*turDao.updateInsertTrattaInTurno(14, 17);
        turDao.updateInsertTrattaInTurno(14, 18);*/
        //bd.updateMezzoDaInserire(4, 23);


//        menu();

        td.isValidAbbonamento(LocalDate.of(2023,10,10),"c7d0755f-4f5e-4987-929e-a19f23160e01");

        em.close();
        emf.close();
    }

    public static void menu(){
        int choice = -1;

        while (choice != 0){
            System.out.println("Benvenuto nell'App Trasporti!");
            System.out.println("Scegli tipo utente: ");
            System.out.println("1 - Admin");
            System.out.println("2 - Utente");
            System.out.println("0 - Exit");
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ex){
                System.err.println(ex.getMessage());
            }
            switch (choice){
                case 1:
                    admin();
                    break;
                case 2:
                    utente();
                    break;
                case 0:
                    System.out.println("0");
                    break;
            }
        }

    }

    public static void admin(){
        EntityManager em = emf.createEntityManager();
        TurnoDAO turDao= new TurnoDAO(em);
        TrattaDAO trd=new TrattaDAO(em);
        Parco_mezziDAO pmd=new Parco_mezziDAO(em);
        ManutenzioneDAO md=new ManutenzioneDAO(em);
        BigliettoDao bd= new BigliettoDao(em);

        int choice = -1;

        while (choice != 0){
            System.out.println("Scegli cosa fare con il tuo mezzo!");
            System.out.println("1 - Scegli il tuo turno e la tratta");
            System.out.println("2 - Se il mezzo non funziona va in manutenzione");
            System.out.println("3 - Controlla se il tuo mezzo è in manutenzione");
            System.out.println("4 - Controlla i biglietti vidimati da eliminare");
            System.out.println("5 - Cerca quanti biglietti sono stati emessi in quel punto di emissione");
            System.out.println("6 - Cerca quante volte in un giorno è stata fatta una tratta");
            System.out.println("7 - Cerca tempo effettivo di percorrenza della tua tratta");
            System.out.println("8 - Cerca biglietti vidiamti su uno specifico mezzo");
            System.out.println("0 - Exit");

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ex){
                System.err.println(ex.getMessage());
            }
            switch (choice){
                case 1:
                    System.out.println("Inserisci orario inizio del tuo servizio");
                    int inizioServizio = Integer.parseInt(input.nextLine());
                    System.out.println("In quanto tempo hai percorso la tua tratta");
                    int tempoEffettivo = Integer.parseInt(input.nextLine());
                    System.out.println("Inserisci id tratta");
                    long id = Integer.parseInt(input.nextLine());
                    Tratta tr = trd.findByid(id);
                    Turno turno1 = new Turno(inizioServizio, tempoEffettivo);
                    turno1.setTratta(tr);
                    turDao.save(turno1);
                    break;
                case 2:
                    System.out.println("Descrivi il tuo guasto al mezzo");
                    LocalDate start = LocalDate.now();
                    System.out.println("Descrivi danno al mezzo");
                    String descrizione = input.nextLine();
                    System.out.println("Qual è il mezzo guasto inserisci id");
                    long id2 = Integer.parseInt(input.nextLine());
                    Parco_mezzi mezzo = pmd.findById(id2);
                    Manutenzione manutenzione = new Manutenzione(start, descrizione, mezzo);
                    md.save(manutenzione);
                    pmd.updateStatoMezzoManutenzione(id2);
                    break;
                case 3:
                    System.out.println("Inserisci id del tuo mezzo");
                    long id3 = Integer.parseInt(input.nextLine());
                    pmd.isUnderMaintenancebyId(id3);
                    break;
                case 4:
                    System.out.println("Premi invio per cancellarli");
                    bd.deleteAllTicketEndorsed();
                    break;
                case 5:
                    System.out.println("Scegli in quale data vuoi fare il controllo");
                    LocalDate data = LocalDate.parse(input.nextLine());
                    System.out.println("Inserisci il puno di emissione");
                    long puntoEmissione = Integer.parseInt(input.nextLine());
                    bd.numeroBigliettiEmmessi(data, puntoEmissione);
                    break;
                case 6:
                    System.out.println("Scegli quale tratta vuoi fare controllo");
                    System.out.println("Inserisci id tratta");
                    long trattaId = Integer.parseInt(input.nextLine());
                    System.out.println("Inserisci id del veicolo che ha percorso la tratta");
                    long mezzoId = Integer.parseInt(input.nextLine());
                    trd.NummeroDiTrattaSingolMezzo(trattaId, mezzoId);
                    break;
                case 7:
                    System.out.println("Inserisci Id del tuo turno");
                    long id4 = Integer.parseInt(input.nextLine());
                    turDao.tempoEffettivoPercorrenzaTratta(id4);
                    break;
                case 8:
                    System.out.println("Inserisci Id biglietto");
                    long id5 = Integer.parseInt(input.nextLine());
                    bd.findById(id5);
                    System.out.println("Inserisci Id mezzo");
                    long id6 = Integer.parseInt(input.nextLine());
                    bd.findById(id6);
                    bd.updateMezzoDaInserire(id5, id6);
                    bd.bigliettoVidimatoSuUnMezzo(id6);
                    break;
                case 0:
                    System.out.println("0");
                    break;
            }
        }
    }

    public static void utente(){
        EntityManager em = emf.createEntityManager();
        UtenteDAO ud= new UtenteDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        BigliettoDao bd= new BigliettoDao(em);
        Tipi_venditaDAO tipidao= new Tipi_venditaDAO(em);
        Parco_mezziDAO pmd=new Parco_mezziDAO(em);
        int choice = -1;

            System.out.println("Inserisci i tuoi dati come nuovo utente");
            System.out.println("Inserisci nome");
            String nome = input.nextLine();
            System.out.println("Inserisci cognome");
            String cognome = input.nextLine();
            System.out.println("Inserisci email");
            String email = input.nextLine();
            System.out.println("Inserisci la tua data di nascita");
            LocalDate dataNascita = LocalDate.parse(input.nextLine());
            Utente user = new Utente(nome, cognome, email, dataNascita);
            ud.save(user);
        while (choice != 0){
            System.out.println("Scegli se creare tessera o biglietto");
            System.out.println("1 - Abbonamento + tessera");
            System.out.println("2 - Biglietto");
            System.out.println("3 - Controlla validità tessera");
            System.out.println("4 - Vidima biglietto");
            System.out.println("5 - Elimina biglietto validato");
            System.out.println("6 - Controlla validità abbonamento");
            System.out.println("0 - Exit");

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ex){
                System.err.println(ex.getMessage());
            }

            switch (choice) {
                case 1:

                    while (choice != 0) {
                        System.out.println("Iserisci data emssione tessera");
                        LocalDate dataEmissione = LocalDate.parse(input.nextLine());
                        System.out.println("Crea abbonamento");
                        System.out.println("1 - Abbonamento mensile");
                        System.out.println("2 - Abbonamento settimanale");

                        choice = Integer.parseInt(input.nextLine());
                        switch (choice){
                            case 1:
                                System.out.println("Inserisci data inizio");
                                LocalDate dataInizio = LocalDate.parse(input.nextLine());
                                System.out.println("Inserisci id User");
                                long id8 = Integer.parseInt(input.nextLine());
                                Utente utente = ud.findUtenteById(id8);
                                Abbonamento abb = new Abbonamento(dataEmissione, utente, Periodicità.Mensile, dataInizio);
                                td.save(abb);
                                break;
                            case 2:
                                System.out.println("Inserisci data inizio");
                                LocalDate dataInizio1 = LocalDate.parse(input.nextLine());
                                System.out.println("Inserisci id User");
                                long id9 = Integer.parseInt(input.nextLine());
                                Utente utente1 = ud.findUtenteById(id9);
                                Abbonamento abb1 = new Abbonamento(dataEmissione, utente1, Periodicità.Settimanale, dataInizio1);
                                td.save(abb1);
                                break;
                        }
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Inserisci data emissione");
                    LocalDate dataEmis = LocalDate.parse(input.nextLine());
                    System.out.println("Inserisci il punto vendita in cui hai fatto biglietto");
                    long id2 = Integer.parseInt(input.nextLine());
                    Tipi_vendita ven = tipidao.findByid(id2);
                    Biglietto biglietto = new Biglietto(dataEmis, ven);
                    bd.save(biglietto);
                    break;
                case 3:
                    System.out.println("Inserisci numero tessera");
                    String isbnString = input.nextLine();
                    UUID id3 = UUID.fromString(isbnString);
                    td.checkValidita(String.valueOf(id3));
                    break;
                case 4:
                    System.out.println("Inserisci biglietto per vidimare");
                    System.out.println("Inserisci id biglietto");
                    long id6 = Integer.parseInt(input.nextLine());
                    bd.findById(id6);
                    System.out.println("Inserisci id mezzo in cui hai vidimato");
                    long id7 = Integer.parseInt(input.nextLine());
                    pmd.findById(id7);
                    bd.updateMezzoDaInserire(id6,id7);
                    break;
                case 5:
                    System.out.println("Inserisci Id biglietto");
                    long id4 = Integer.parseInt(input.nextLine());
                    bd.findById(id4);
                    bd.checkTicketAndNull(id4);
                    break;
                case 6:
                    System.out.println("Inserisci data di inizio abbonamento");
                    LocalDate data = LocalDate.parse(input.nextLine());
                    System.out.println("Inserisci UUID");
                    String is = input.nextLine();
                    UUID id5 = UUID.fromString(is);
                    td.isValidAbbonamento(data, String.valueOf(id5));
                    break;
                case 0:
                    System.out.println("0");
                    break;
            }
        }
    }
}
