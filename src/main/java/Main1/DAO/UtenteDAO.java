package Main1.DAO;

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
        System.out.println("NUovo utente inserito " + utente.getNome());

    }
}


