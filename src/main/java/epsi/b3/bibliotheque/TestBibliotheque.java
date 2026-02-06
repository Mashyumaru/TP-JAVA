package epsi.b3.bibliotheque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TestBibliotheque {
    static void main() {
        try(
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
                EntityManager em = emf.createEntityManager()
        ){
            em.getTransaction().begin();

            TypedQuery<Livre> queryEmprunt = em.createQuery("select l from Livre l join l.emprunts e where e.id = 1",
                    Livre.class);
            List<Livre> livresEmprunt = queryEmprunt.getResultList();
            System.out.println("Livre associés à l'Emprunt 1 : ");
            for (Livre livre: livresEmprunt){
                System.out.println(livre);
            }


            TypedQuery<Emprunt> queryEmpruntClient = em.createQuery("select e from Emprunt e join e.client c where c.id = 1",
                    Emprunt.class);
            List<Emprunt> livresEmpruntClient = queryEmpruntClient.getResultList();
            System.out.println("Emprunt associés au Client 1 : ");
            for (Emprunt emprunt: livresEmpruntClient){
                System.out.println(emprunt);
            }

            em.getTransaction().commit();
        }

    }
}
