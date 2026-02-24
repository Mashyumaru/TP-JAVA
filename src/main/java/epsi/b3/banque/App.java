package epsi.b3.banque;

import epsi.b3.bibliotheque.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public class App {
    static void main() {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
            EntityManager em = emf.createEntityManager();
        ){
//            em.getTransaction().begin();
//
//            Adresse a = new Adresse(1, "rue de rue", 44000, "Nantes");
//            Banque b = new Banque();
//            b.setNom("SOGE");
//            Compte compte = new Compte();
//            Client client = new Client("Aurélien", "MARCHAND", LocalDate.of(2000, 3, 21), a, b, Set.of(compte));
//
//            em.persist(client);

        }
    }


}
