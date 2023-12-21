package Main1.DAO;

import Main1.entities.Manutenzione;
import Main1.entities.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

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
    public void vehicleUnderMaintenancebyId(long id){
        Query getvehicleUnnderMaintenancebyId= em.createQuery("SELECT v FROM Manutenzione v JOIN v.parco_mezzi p  WHERE p.id = :id", Manutenzione.class);
        getvehicleUnnderMaintenancebyId.setParameter("id",id);
        List<Manutenzione>mezzi=getvehicleUnnderMaintenancebyId.getResultList();
        mezzi.forEach(elm->System.out.println(elm));

    }
}
