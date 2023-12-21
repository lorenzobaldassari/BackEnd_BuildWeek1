package Main1.DAO;

import Main1.entities.Abbonamento;
import Main1.entities.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.List;

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

    public Tessera findByUUID(UUID numero_tessera) {

        return (Tessera) this.em.find(Tessera.class, numero_tessera);

    }

    public void findByUUIDAndDelete(UUID numero_tessera) {
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


    public void checkValidita(long numero_tessera) {
        Query getNummeroDiTrattaSingolMezzo = em.createQuery("SELECT b FROM Abbonamento b WHERE b.numero_tessera=:numero_tessera", Abbonamento.class);
        ;
        getNummeroDiTrattaSingolMezzo.setParameter("numero_tessera", numero_tessera);
        List<Abbonamento> abbo = getNummeroDiTrattaSingolMezzo.getResultList();
        abbo.forEach(el -> {
            if (abbo.size() > 0) {
                if (el.isValidità()) {

                    System.out.println("utente con numero di tessera  " + el.getNumero_tessera() + " ha l'abbonamento valido");
                } else {
                    System.out.println("abbonamento non valido");
                }
            } else {
                System.out.println("non esiste questo numero di tessera");
            }
        });

    }

}


