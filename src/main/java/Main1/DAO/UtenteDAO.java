package Main1.DAO;

import Main1.entities.Tessera;
import Main1.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class UtenteDAO {


    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente
    ) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("NUovo utente inserito " + utente.getNome() + " " + utente.getCognome());

    }

    public Utente findUtenteById(long id) {

        return (Utente) this.em.find(Utente.class, id);

    }

    public void findByUtendeIdAndDelete(long id) {
        try {
            EntityTransaction t = this.em.getTransaction();
            Utente found = (Utente) this.em.find(Utente.class, id);
            if (found != null) {
                t.begin();
                this.em.remove(found);
                t.commit();
                System.out.println("Utente Eliminato");
            } else {
                System.out.println("Utente non trovato");
            }
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }
    }


}


