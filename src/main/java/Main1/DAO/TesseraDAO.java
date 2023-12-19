package Main1.DAO;

import Main1.entities.Tessera;
import Main1.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

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
        System.out.println("NUova tessera utente inserita " + tessera.getNumero_tessera());


    }

    public Tessera findById(long id) {

        return (Tessera) this.em.find(Tessera.class, id);

    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = this.em.getTransaction();
            Tessera found = (Tessera) this.em.find(Tessera.class, id);
            if (found != null) {
                t.begin();
                this.em.remove(found);
                t.commit();
                System.out.println("Tessera Eliminata");
            } else {
                System.out.println("Tessera non trovata");
            }
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }
    }


}


