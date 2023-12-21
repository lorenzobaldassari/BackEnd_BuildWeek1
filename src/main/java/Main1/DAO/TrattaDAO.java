package Main1.DAO;

import Main1.entities.Parco_mezzi;
import Main1.entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class TrattaDAO {
    private final EntityManager em;

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(tratta);
        transaction.commit();
    }

    public Tratta findByid(long id) {
        return em.find(Tratta.class, id);
    }

    public void findByZonaDiPartenzaAndDelete(String zona_di_partenza) {

        Tratta found = em.find(Tratta.class,zona_di_partenza);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("la tratta" + found.getZona_partenza() + " è stata cancellata!");

        } else {

            System.out.println("la tratta con la zona di partenza" + zona_di_partenza + " non è stata trovata");
        }
    }
    public int NummeroDiTrattaSingolMezzo(String partenza,String capolinea,long id_mezzo){
        Query getNummeroDiTrattaSingolMezzo=em.createQuery("SELECT m FROM Parco_mezzi m JOIN m.tratte t WHERE t.zona_partenza=:partenza " + "AND t.capolinea=:capolinea");
        getNummeroDiTrattaSingolMezzo.setParameter("partenza",partenza);
        getNummeroDiTrattaSingolMezzo.setParameter("capolinea",capolinea);
       List<Parco_mezzi> mezzo=getNummeroDiTrattaSingolMezzo.getResultList();
       if(mezzo.size()==0){
           System.out.println("questo mezzo non ha mai compiuto questa tratta");
       }
       return mezzo.stream().filter(elem-> elem.getId()==id_mezzo).toList().size();
    }

}
