package Main1.DAO;

import Main1.entities.Manutenzione;
import Main1.entities.Turno;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

    public int tempoEffettivoPercorrenzaTratta(int tempoEffettivo, int tempoPercorso){
        Query getTempoEffettivoPercorrenza = em.createQuery("SELECT t FROM Turno t JOIN t.tratta z WHERE t.tempo_effettivo_percorrenza BETWEEN :tempoEffettivo AND z.tempoPercoreenzaInMinuti AND z.tempoPercoreenzaInMinuti <= :tempoPercorso", Turno.class);
        getTempoEffettivoPercorrenza.setParameter("tempoEffettivo", tempoEffettivo);
        getTempoEffettivoPercorrenza.setParameter("tempoPercorso", tempoPercorso);
        return getTempoEffettivoPercorrenza.getFirstResult();

    }
}
