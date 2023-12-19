package Main1;

import Main1.DAO.Parco_mezziDAO;
import Main1.DAO.TrattaDAO;
import Main1.entities.Bus;
import Main1.entities.Enum.Stato;
import Main1.entities.Parco_mezzi;
import Main1.entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Application {


    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        TrattaDAO trd = new TrattaDAO(em);
        Parco_mezziDAO pmd = new Parco_mezziDAO(em);
        Parco_mezzi bus1 = new Bus(Stato.IN_SEVIZIO);

        Tratta uno= new Tratta("Milano","Roma",120);
       //bus1.insertTratta(uno);
       //trd.save(uno);
       //pmd.save(bus1);
        trd.NummeroDiTrattaSingolMezzo("Milano","Roma");

        em.close();
        emf.close();
    }


}


