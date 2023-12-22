package Main1.DAO;

import Main1.entities.Abbonamento;
import Main1.entities.Manutenzione;
import Main1.entities.Tipi_vendita;
import Main1.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class AbbonamentoDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

    private final EntityManager em;
    public AbbonamentoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Abbonamento abbbonamento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(abbbonamento);
        transaction.commit();
        System.out.println("elemento "+ abbbonamento.getNumero_tessera()+" salvato con successo");
    }

    public Abbonamento findById(long id){
        Abbonamento find= em.find(Abbonamento.class, id);
        if (find!=null){
            System.out.println("elemento trovato "+find );
            return find;
        }else{
            System.out.println("id non trovato");
            return null;
        }
    }

    public void findByIdAndDelete(long id){

        EntityTransaction transaction=em.getTransaction();
        Abbonamento abbonamento = findById(id);
        if (abbonamento !=null){
            transaction.begin();
            em.remove(abbonamento);
            transaction.commit();
            System.out.println("elemento "+abbonamento.getNumero_tessera() +" eliminato");
        }else{
            System.out.println("non esiste l'elemento");
        }
    }

    public void updateDataInizioEScadenza(long id_abbonamento, LocalDate nuovaDataDiInzio__yyyy_m_dd){

        Abbonamento mac= this.findById(id_abbonamento);
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        mac.setData_inizio(nuovaDataDiInzio__yyyy_m_dd);
        mac.calcolaDataFine();
        transaction.commit();
        System.out.println("aggiunto correttamente");
    }

    public void updateVenditoreAssociato(long id_abbonamento, long id_venditoreDaInserire){
        Tipi_venditaDAO tipiVenditaDAO= new Tipi_venditaDAO(em);
        Abbonamento mac= this.findById(id_abbonamento);
        Tipi_vendita tipo= tipiVenditaDAO.findByid(id_venditoreDaInserire);
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        mac.setTipi_vendita(tipo);
        mac.calcolaDataFine();
        transaction.commit();
        System.out.println("aggiunto correttamente");
    }
    public void cambiareLaValidita(long id_abbonamento, boolean trueOrFalse){
        Abbonamento mac= this.findById(id_abbonamento);
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        mac.setValidità(trueOrFalse);
        mac.calcolaDataFine();
        transaction.commit();
        System.out.println("aggiunto correttamente");
    }
    public void inserireUtente(long id_abbonamento, long id_utente){
        UtenteDAO utenteDAO= new UtenteDAO(em);
        Abbonamento mac= this.findById(id_abbonamento);
        Utente utenteDaInserire = utenteDAO.findUtenteById(id_utente);
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        mac.setUtente(utenteDaInserire);
        mac.calcolaDataFine();
        transaction.commit();
        System.out.println("aggiunto correttamente");
    }

}
