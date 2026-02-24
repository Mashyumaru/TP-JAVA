package epsi.b3.banque;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Banque")
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "banque")
    private Set<Client> clients;

    public Banque() {
    }

    public Banque(String nom, Set<Client> clients) {
        this.nom = nom;
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", clients=" + clients +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
