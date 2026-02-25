package epsi.b3.petstore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;

public class App {
    static void main() {
        try (
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
            EntityManager em = emf.createEntityManager()
        ) {
            em.getTransaction().begin();

            // Création des adresses
            Address address1 = new Address("5", "rue des animaux", "44000", "Nantes", null);
            Address address2 = new Address("12", "rue des alouettes", "35000", "Rennes", null);
            Address address3 = new Address("37", "rue des inondations", "49000", "Angers", null);

            em.persist(address1);
            em.persist(address2);
            em.persist(address3);

            // Création des petStores
            PetStore petStore1 = new PetStore("MaxiZoo", "Marchand", new HashSet<>(), address1, new HashSet<>());
            PetStore petStore2 = new PetStore("Paradis du Waf", "Sylla", new HashSet<>(), address2, new HashSet<>());
            PetStore petStore3 = new PetStore("Herbe à chat", "Gascon", new HashSet<>(), address3, new HashSet<>());

            em.persist(petStore1);
            em.persist(petStore2);
            em.persist(petStore3);

            // Création des animaux cats/fishes
            Cat cat1 = new Cat(Date.valueOf("2025-03-21"), "Orange", petStore3, "JoliMatou");
            Cat cat2 = new Cat(Date.valueOf("2024-07-12"), "Noir", petStore3, "FelixLeChat");
            Cat cat3 = new Cat(Date.valueOf("2023-06-10"), "Tigré", petStore3, "LeJoliChat");

            em.persist(cat1);
            em.persist(cat2);
            em.persist(cat3);

            Fish fish1 = new Fish(Date.valueOf("2025-12-12"), "Bleu", petStore1, FishLivEnv.FRESH_WATER);
            Fish fish2 = new Fish(Date.valueOf("2026-01-25"), "Jaune", petStore2, FishLivEnv.FRESH_WATER);

            em.persist(fish1);
            em.persist(fish2);

            // Création et ajout des produits dans les petStores
            Product product1 = new Product("123456789", "Laisse", ProdType.ACCESSORY, 12.99, new HashSet<>());
            product1.getPetStores().add(petStore1);
            product1.getPetStores().add(petStore2);
            petStore1.getProducts().add(product1);
            petStore2.getProducts().add(product1);
            em.persist(product1);

            Product product2 = new Product("987456321", "Nourriture pour poisson", ProdType.FOOD, 50.20, new HashSet<>());
            product2.getPetStores().add(petStore1);
            product2.getPetStores().add(petStore2);
            petStore1.getProducts().add(product2);
            petStore2.getProducts().add(product2);
            em.persist(product2);

            Product product3 = new Product("987654321", "Herbe à chat", ProdType.ACCESSORY, 7.50, new HashSet<>());
            product3.getPetStores().add(petStore3);
            petStore3.getProducts().add(product3);
            em.persist(product3);

            // Requete permettant de récuperer tous les animaux du petStore "Herbe à chat"
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a JOIN a.petStore p WHERE p.name = 'Herbe à chat'", Animal.class);
            List<Animal> animals = query.getResultList();

            for (Animal a: animals){
                System.out.println(a);
            }




            em.getTransaction().commit();

        }
    }
}
