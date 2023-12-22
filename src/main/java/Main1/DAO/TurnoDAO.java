package Main1.DAO;

import Main1.entities.Manutenzione;
import Main1.entities.Parco_mezzi;
import Main1.entities.Tratta;
import Main1.entities.Turno;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");


    private final EntityManager em;

    public TurnoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Turno turno) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(turno);
        transaction.commit();
        System.out.println("Nuovo turno iniziato " + turno.getInizio_servizio() + " delle tratta " +  turno.getTratta() + " inserito");

    }

    public Turno findById(long id) {
        // SELECT * FROM students WHERE students.id=1
        return em.find(Turno.class, id);
    }

    public void findByDateAndDelete(long id) {

        Turno found = em.find(Turno.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Il turno è stato cancellato correttamente");
        } else {
            System.err.println("Il turno con l'id " + id + " non è stato trovato");
        }

    }
    public void tempoEffettivoPercorrenzaTratta(long id){
        Query getTempoEffettivoPercorrenza = em.createQuery("SELECT t FROM Turno t JOIN FETCH t.tratta z WHERE t.id = :id",Turno.class);
        //AND z.tempoPercoreenzaInMinuti <= :tratta",
        getTempoEffettivoPercorrenza.setParameter("id", id);
        List<Turno> turni = getTempoEffettivoPercorrenza.getResultList();
//        System.out.println("Numero di turni trovati: " + turni.size());

        turni.forEach(elm -> {
//            System.out.println("Turno ID: " + elm.getId());
//            System.out.println("Tratte associate: " + elm.getTratta().size());

            List<Integer> intlist = new ArrayList<>();
            elm.getTratta().forEach(elmn -> {
                intlist.add(elmn.getTempoPercoreenzaInMinuti());
//                System.out.println("Tratta ID: " + elmn.getId() + ", Tempo: " + elmn.getTempoPercoreenzaInMinuti());
            });

            int somma = intlist.stream().reduce(0, Integer::sum);
            if ((elm.getTempo_effettivo_percorrenza() - somma)>=0){
                System.out.println("sei in ritardo di " + (elm.getTempo_effettivo_percorrenza() - somma)+" minuti");
            }else{

            System.out.println("sei in anticipo di " + (somma-elm.getTempo_effettivo_percorrenza())+" minuti");
            }
        });

    }
    public void updateInsertTrattaInTurno(long id_turno, long id_trattaDaInserire){
        TrattaDAO trattaDAO= new TrattaDAO(em);
        Tratta trattaDaInserire= trattaDAO.findByid(id_trattaDaInserire);
        Turno mac= this.findById(id_turno);
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        mac.setTratta(trattaDaInserire);
        transaction.commit();
        System.out.println("aggiunto correttamente");
    }

}
