package Main1.DAO;

import Main1.entities.Biglietto;
import Main1.entities.Distributore_automatico;
import Main1.entities.Tipi_vendita;

import javax.persistence.*;

import Main1.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.List;

public class BigliettoDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");
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
 public void checkTicketAndNull(long id){
     EntityTransaction transaction=em.getTransaction();
     Query getcheckTicketAndNull=em.createQuery("SELECT b FROM Biglietto b WHERE b.id =: id",Biglietto.class);
     getcheckTicketAndNull.setParameter("id",id);

    List<Biglietto> getcheckTicket=getcheckTicketAndNull.getResultList();
    getcheckTicket.forEach(elm ->{
        if(elm.isVidimazione()){
            transaction.begin();
            em.remove(elm);
            transaction.commit();
            System.out.println("il blietto con id "+elm.getId() +" eliminato");
        }else{
            System.out.println("il biglietto non è stato vidimato");
        }
    });
 }
 public void deleteAllTicketEndorsed(){
     EntityTransaction transaction=em.getTransaction();
     Query getdeleteAllTicketEndorsed=em.createQuery("SELECT b FROM Biglietto b WHERE b.vidimazione is true", Biglietto.class);
     List<Biglietto>allTicketEndorsed =getdeleteAllTicketEndorsed.getResultList();
     if (allTicketEndorsed.size()>0) {
         allTicketEndorsed.forEach(elm -> {
             transaction.begin();
             em.remove(elm);
             transaction.commit();

         });
         System.out.println(allTicketEndorsed.size()+ " biglietti vidimati sono stati eliminati");

     }
     else{
         System.out.println("biglietti vidimati non presenti");
     }
    }


    public int numeroBigliettiEmmessi(LocalDate emissione, String puntoEmissione) {
        TypedQuery<Biglietto> numeroBiglietti = em.createQuery("SELECT b FROM Biglietto b JOIN b.tipi_vendita v " +
                "WHERE b.emissione = :emissione AND v.puntoDiEmissione LIKE :punto_emissione", Biglietto.class);
        numeroBiglietti.setParameter("emissione", emissione);
        numeroBiglietti.setParameter("punto_emissione", puntoEmissione);
        List<Biglietto> big = numeroBiglietti.getResultList();
        if(big.size()==0){
            System.out.println("non sono stati venduti biglietti il "+ emissione+ "nel punto vendita a "+ puntoEmissione);
        }else{
            System.out.println("sono stati venduti "+big.size()+" biglietti il "+ emissione+
                    "nel punto vendita a "+ puntoEmissione);
        }
        return big.size();
    }

        public void numeroDiBigliettoPerPeriodoEDistributore(LocalDate inizio, String tipovendita){

            if (tipovendita.equals("Rivenditori_autorizzati")) {
                Query getNummeroDiTrattaSingolMezzo = em.createQuery("SELECT b FROM Biglietto b JOIN TREAT(b.tipi_vendita AS Rivenditori_autorizzati) d " +
                        "WHERE d.condizione is null  ", Biglietto.class);
                List<Biglietto> abbo = getNummeroDiTrattaSingolMezzo.getResultList();
                int numebrOfTickets = abbo.size();
                System.out.println(numebrOfTickets);
            } else if (tipovendita.equals("Distributore_automatico")) {
                Query getNummeroDiTrattaSingolMezzo = em.createQuery("SELECT b FROM Biglietto b JOIN TREAT(b.tipi_vendita AS Distributore_automatico) d " +
                        "WHERE d.condizione is not null  ", Biglietto.class);
                List<Biglietto> abbo = getNummeroDiTrattaSingolMezzo.getResultList();
                int numebrOfTickets = abbo.size();
                System.out.println(numebrOfTickets);
            }

        }

    public void updateMezzoDaInserire(long id_biglietto,long id_mezzo_da_inserire){
        Parco_mezziDAO pmd=new Parco_mezziDAO(em);
        Biglietto bi= this.findById(id_biglietto);
        Parco_mezzi mac= pmd.findById(id_mezzo_da_inserire);
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        bi.setParco_mezzi(mac);
        transaction.commit();
        System.out.println("aggiunto correttamente");
    }
    public void updateTipoDiVenditore(long id_biglietto,long id_venditore){
        Tipi_venditaDAO pmd=new Tipi_venditaDAO(em);
        Biglietto bi= this.findById(id_biglietto);
        Tipi_vendita mac= pmd.findByid(id_venditore);
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        bi.setTipi_vendita(mac);
        transaction.commit();
        System.out.println("aggiunto correttamente");
    }


    }

