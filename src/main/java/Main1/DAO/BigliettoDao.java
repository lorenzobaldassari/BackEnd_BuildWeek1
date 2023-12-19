package Main1.DAO;

import Main1.entities.Biglietto;
import Main1.entities.Distributore_automatico;
import Main1.entities.Tipi_vendita;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class BigliettoDao {

    private final EntityManager em;

    public BigliettoDao(EntityManager em){
        this.em= em;
    }

    public void save(Biglietto biglietto){
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.persist(biglietto);
        transaction.commit();
        System.out.println("il biglietto con id  "+ biglietto.getId()+" salvato con successo");
    }

    public Biglietto findById(long id){
        Biglietto find= em.find(Biglietto.class, id);
        if (find!=null){
            System.out.println("elemento trovato "+find );
            return find;
        }else{
            System.out.println("id non trovato");
            return null;
        }
    }

    public void findByIdAndDelete(long id){

        EntityTransaction transaction=em.getTransaction();
        Biglietto biglietto = findById(id);
        if (biglietto !=null){
            transaction.begin();
            em.remove(biglietto);
            transaction.commit();
            System.out.println("elemento "+biglietto.getId() +" eliminato");
        }else{
            System.out.println("non esiste l'elemento");
        }
    }

    public int numeroBigliettiEmmessi(LocalDate emissione, String puntoEmissione){
        TypedQuery<Biglietto> numeroBiglietti = em.createQuery("SELECT b FROM Biglietto b JOIN b.tipi_vendita v WHERE b.emissione = :emissione AND v.puntoDiEmissione LIKE :punto_emissione", Biglietto.class);
        numeroBiglietti.setParameter("emissione", emissione);
        numeroBiglietti.setParameter("punto_emissione", puntoEmissione);
        List<Biglietto> big = numeroBiglietti.getResultList();
        return big.size();
    }

}
