package Main1.DAO;

import Main1.entities.Tipi_vendita;
import Main1.entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Tipi_venditaDAO {
    private final EntityManager em;
    public Tipi_venditaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tipi_vendita tipi_vendita) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(tipi_vendita);
        transaction.commit();

        System.out.println("elemnto salvato tipovendita!");
    }

    public Tipi_vendita findByid(long id) {
        return em.find(Tipi_vendita.class, id);
    }

    public void findByPuntoDiEmissioneAndDelete(String punto_emissione) {

        Tipi_vendita found=  em.find(Tipi_vendita.class, punto_emissione);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("il tipo di vendita" + found.getPuntoDiEmissione() + " è stata eliminata!");
        } else {

            System.out.println("il tipo di vendita con il punto di emissione " + punto_emissione + " non è stata trovata");
        }
    }
}
