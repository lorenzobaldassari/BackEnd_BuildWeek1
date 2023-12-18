package Main1.DAO;

import Main1.entities.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesseraDAO {

    private final EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tessera tessera
    ) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(tessera);
        transaction.commit();
        System.out.println("NUovo utente inserito " + tessera.getNumero_tessera());

    }
}


