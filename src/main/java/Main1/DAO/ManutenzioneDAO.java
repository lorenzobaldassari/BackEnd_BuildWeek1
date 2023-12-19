package Main1.DAO;

import Main1.entities.Manutenzione;
import Main1.entities.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ManutenzioneDAO {
    private final EntityManager em;

    public ManutenzioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Manutenzione manutenzione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(manutenzione);
        transaction.commit();
        System.out.println("Nuova manutenzione per " + manutenzione.getDescription() + " inserita");

    }

    public Manutenzione findById(long id) {
        // SELECT * FROM students WHERE students.id=1
        return em.find(Manutenzione.class, id);
    }

    public void findByDateAndDelete(long id) {

        Manutenzione found = em.find(Manutenzione.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Il post è stato cancellato correttamente");
        } else {
            System.err.println("Il post con l'id " + id + " non è stato trovato");
        }

    }
}
