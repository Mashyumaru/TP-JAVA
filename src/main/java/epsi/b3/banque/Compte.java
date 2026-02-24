package epsi.b3.banque;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero")
    private String numero;
    @Column(name = "solde")
    private double solde;
    @ManyToMany
    @JoinTable(name = "CLI_CPT",
            joinColumns = @JoinColumn(name = "ID_CPT", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")
    )
    private Set<Client> clients;
    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    public Compte(String numero, double solde, Set<Client> clients, Set<Operation> operations) {
        this.numero = numero;
        this.solde = solde;
        this.clients = clients;
        this.operations = operations;
    }

    public Compte() {
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                ", clients=" + clients +
                ", operations=" + operations +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
