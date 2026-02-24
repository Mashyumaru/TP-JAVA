package epsi.b3.banque;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type")
public class Operation {

    public Operation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "montant")
    private double montant;

    @Column(name = "motif")
    private String motif;


    @ManyToOne
    @JoinColumn(name = "ID_COMPTE")
    private Compte compte;

    public Operation(LocalDateTime date, double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", date=" + date +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                ", compte=" + compte +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
