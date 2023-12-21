package Main1.DAO;

import Main1.entities.Manutenzione;
import Main1.entities.Tratta;
import Main1.entities.Turno;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class TurnoDAO {

    private final EntityManager em;

    public TurnoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Turno turno) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(turno);
        transaction.commit();
        System.out.println("Nuovo turno iniziato " + turno.getInizio_servizio() + " delle tratta " +  turno.getTratta() + " inserito");

    }

    public Turno findById(long id) {
        // SELECT * FROM students WHERE students.id=1
        return em.find(Turno.class, id);
    }

    public void findByDateAndDelete(long id) {

        Turno found = em.find(Turno.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Il turno è stato cancellato correttamente");
        } else {
            System.err.println("Il turno con l'id " + id + " non è stato trovato");
        }

    }




    public int tempoEffettivoPercorrenzaTratta(Turno turno, Tratta tratta){
        Query getTempoEffettivoPercorrenza = em.createQuery("SELECT t FROM Turno t JOIN t.tratta z WHERE t.tempo_effettivo_percorrenza = :turno AND z.tempoPercoreenzaInMinuti <= :tratta", Turno.class);
        getTempoEffettivoPercorrenza.setParameter("turno", turno);
        getTempoEffettivoPercorrenza.setParameter("tratta", tratta);
       int tra = getTempoEffettivoPercorrenza.getFirstResult();
        return  tra;

    }
}
