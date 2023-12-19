package Main1.DAO;


import Main1.entities.Parco_mezzi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Parco_mezziDAO {

    private final EntityManager em;
    public Parco_mezziDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Parco_mezzi mezzi) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(mezzi);
        transaction.commit();
        System.out.println("Nuovo mezzo inserito " + mezzi.getClass());
    }


    public Parco_mezzi findById(long id) {
        // SELECT * FROM students WHERE students.id=1
        return em.find(Parco_mezzi.class, id);
    }

    public void findByDateAndDelete(long id) {

        Parco_mezzi found = em.find(Parco_mezzi.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Il mezzo è stato cancellato correttamente");
        } else {
            System.err.println("Il mezzo con l'id: " + id + " non è stato trovato");
        }

    }
}
