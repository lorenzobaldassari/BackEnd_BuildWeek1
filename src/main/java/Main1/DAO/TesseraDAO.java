package Main1.DAO;

import Main1.entities.Tessera;
import Main1.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
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

    public Tessera findById(long numero_tessera) {

        return (Tessera) this.em.find(Tessera.class, numero_tessera);

    }

    public void findByIdAndDelete(long numero_tessera) {
        try {
            EntityTransaction t = this.em.getTransaction();
            Tessera found = (Tessera) this.em.find(Tessera.class, numero_tessera);
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

    public boolean isValidAbbonamento(LocalDate checkDate, long numero_tessera) {
        Query query = em.createQuery("SELECT 1 FROM Abbonamento a " +
                "WHERE a.emissione <= :checkDate " +
                "AND a.data_inizio <= :checkDate " +
                "AND a.data_fine >= :checkDate " +
                "AND a.numero_tessera = :numeroTessera");

        query.setParameter("checkDate", checkDate);
        query.setParameter("numeroTessera", numero_tessera);

        return !query.getResultList().isEmpty();
    }


}


