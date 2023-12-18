package Main1.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_nascita;

    @OneToOne
    @JoinColumn(name = "numero_tessera")
    private Tessera tessera;

    public Utente() {
    }

    public Utente(String nome, String cognome, String email, LocalDate data_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_nascita = data_nascita;
    }


    public long getId() {
        return id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }
}
