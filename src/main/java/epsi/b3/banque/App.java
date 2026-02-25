package epsi.b3.banque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Set;


public class App {
    static void main() {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
            EntityManager em = emf.createEntityManager()
        ){
            em.getTransaction().begin();
            Compte compte1 = new Compte();
            Client client1 = new Client();
            Client client2 = new Client();
            client1.setComptes(Set.of(compte1));
            client2.setComptes(Set.of(compte1));



            em.persist(compte1);
            em.persist(client1);
            em.persist(client2);


            Client client3 = new Client();

            Compte assuranceVie = new AssuranceVie();
            Compte livretA = new LivretA();

            assuranceVie.setClients(Set.of(client3));
            livretA.setClients(Set.of(client3));

            em.persist(assuranceVie);
            em.persist(livretA);
            em.persist(client3);

            Virement v = new Virement();
            Operation o = new Operation();


            v.setCompte(livretA);
            o.setCompte(compte1);

            em.persist(v);
            em.persist(o);


            em.getTransaction().commit();
//            Adresse a = new Adresse(1, "rue de rue", 44000, "Nantes");
//            Banque b = new Banque();
//            b.setNom("SOGE");
//            Compte compte = new Compte();
//            Client client = new Client("Aurélien", "MARCHAND", LocalDate.of(2000, 3, 21), a, b, Set.of(compte));
        }
    }


}
