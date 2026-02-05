package epsi.b3.bibliotheque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class App {
    static void main() {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
            EntityManager em = emf.createEntityManager();
        ){
            em.getTransaction().begin();

            Livre l = em.find(Livre.class, 1);
            if (l != null){
                System.out.println(l.getAuteur() + "\n" + l.getTitre());
            }

            Livre livreAvecErreur = em.find(Livre.class, 5);
            if (livreAvecErreur != null){
                livreAvecErreur.setTitre("Du plaisir dans la cuisine");
            }

            insertBook(em, "Les fleurs du mal", "Baudelaire");
            em.getTransaction().commit();


            TypedQuery<Livre> queryTitre = em.createQuery("select l from Livre l where l.titre='Du plaisir dans la cuisine'",
                    Livre.class);
            List<Livre> livresTitre = queryTitre.getResultList();
            System.out.println("Livre avec Titre : ");
            for (Livre livre: livresTitre){
                System.out.println(livre);
            }

            TypedQuery<Livre> queryAuteur = em.createQuery("select l from Livre l where l.auteur='Baudelaire'",
                    Livre.class);
            List<Livre> livresAuteur = queryAuteur.getResultList();
            System.out.println("Livre avec Auteur : ");
            for (Livre livre: livresAuteur){
                System.out.println(livre);
            }

            Livre livreDelete = em.find(Livre.class, 2);
            if (livreDelete != null){
                em.remove(livreDelete);
            }

            TypedQuery<Livre> queryAll = em.createQuery("select l from Livre l ",
                    Livre.class);
            List<Livre> livresAll = queryAuteur.getResultList();
            System.out.println("Livre avec Auteur : ");
            for (Livre livre: livresAll){
                System.out.println(livre);
            }




        }
    }


    static void insertBook(EntityManager em, String titre, String auteur){
        Livre l = new Livre(titre, auteur);
        em.persist(l);
    }
}
