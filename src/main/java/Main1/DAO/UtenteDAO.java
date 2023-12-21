package Main1.DAO;

import Main1.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UtenteDAO {


    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente
    ) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("NUovo utente inserito " + utente.getNome() + " " + utente.getCognome());

    }

    public Utente findUtenteById(long id) {

        return (Utente) this.em.find(Utente.class, id);

    }

    public void findByUtendeIdAndDelete(long id) {
        try {
            EntityTransaction t = this.em.getTransaction();
            Utente found = (Utente) this.em.find(Utente.class, id);
            if (found != null) {
                t.begin();
                this.em.remove(found);
                t.commit();
                System.out.println("Utente Eliminato");
            } else {
                System.out.println("Utente non trovato");
            }
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }
    }

    public void inin(){

        List<Tratta> tratta= new ArrayList<>();
        List<Integer> intlist= new ArrayList<>();
        tratta.stream().forEach(elm-> intlist.add(elm.getTempoPercoreenzaInMinuti()));
        intlist.stream().reduce(0,(tot,elem)->tot+elem);

    }


}


