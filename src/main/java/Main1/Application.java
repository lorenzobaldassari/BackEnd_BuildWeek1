package Main1;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("Trasporto_Pubblico");
    public static void main(String[] args) {
        System.out.println("Hello World1!");
    }
}
