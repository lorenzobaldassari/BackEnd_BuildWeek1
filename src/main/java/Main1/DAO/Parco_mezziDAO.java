package Main1.DAO;

import Main1.entities.Enum.Stato;
import Main1.entities.Parco_mezzi;
import Main1.entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

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

    public void isUnderMaintenancebyId(long id){
        Query getvehicleUnnderMaintenancebyId= em.createQuery("SELECT p FROM Parco_mezzi p"+
                " WHERE p.id = :id", Parco_mezzi.class);
        getvehicleUnnderMaintenancebyId.setParameter("id",id);
        List<Parco_mezzi> mezzi=getvehicleUnnderMaintenancebyId.getResultList();
        mezzi.stream().forEach(elem->{
            if(elem.getStato()== Stato.IN_MANUTENZIONE){
                System.out.println("questo mezzo e' in manutenzione");
                System.out.println(elem);
            }else if(elem.getStato()== Stato.IN_SERVIZIO){
                System.out.println("il mezzo e' operativo");
                System.out.println(elem);
            }else{
                System.out.println("l'id non e' associato a nessun mezzo!");
            }
        });
    }


    public void updateInsertTratta(long id_mezzo, Tratta trattaDaInserire){
        Parco_mezzi mac= this.findById(id_mezzo);
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        mac.insertTratta(trattaDaInserire);
        transaction.commit();
        System.out.println("aggiunto correttamente");
    }

}
