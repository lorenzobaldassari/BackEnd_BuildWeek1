package Main1.DAO;

import Main1.entities.Manutenzione;
import Main1.entities.Parco_mezzi;
import Main1.entities.Tessera;
import Main1.entities.Tratta;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class ManutenzioneDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

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
            System.out.println("La manutenzione è stata cancellata correttamente");
        } else {
            System.err.println("La manutenzione con " + id + " non è stata trovat");
        }

    }
    public void vehicleUnderMaintenancebyId(long id){
        Query getvehicleUnnderMaintenancebyId= em.createQuery("SELECT v FROM Manutenzione v JOIN " +
                "v.parco_mezzi p  WHERE p.id = :id", Manutenzione.class);
        getvehicleUnnderMaintenancebyId.setParameter("id",id);
        List<Manutenzione>mezzi=getvehicleUnnderMaintenancebyId.getResultList();
        if(mezzi.size()==0){
            System.out.println("questo mezzo non e' in manutenzione o il mezzo non esiste");
        }else{
            System.out.println("le manutenzioni di questo mezzo sono:");
        mezzi.forEach(elm->System.out.println(elm));
        }

    }

    public void updateGiornoDiFine(long id_manutenzione, LocalDate giornoDiFine__yyyy_m_dd){
        Manutenzione mac= this.findById(id_manutenzione);
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        mac.setGiorno_fine(giornoDiFine__yyyy_m_dd);
        transaction.commit();
        System.out.println("aggiunto correttamente");
    }
    public void insertVaichle(long id_manutenzione,long id_veicolo){
        Parco_mezziDAO mezziDAO= new Parco_mezziDAO(em);
        Parco_mezzi mezzo= mezziDAO.findById(id_veicolo);
        Manutenzione mac= this.findById(id_manutenzione);
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        mac.setParco_mezzi(mezzo);
        transaction.commit();
        System.out.println("aggiunto correttamente");
    }
}
