package epsi.b3.petstore;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "birth")
    private Date birth;
    @Column(name = "couleur")
    private String couleur;

    @ManyToOne
    @JoinColumn(name = "petStore_id")
    private PetStore petStore;


    /*
     * Constructeurs
     * */

    public Animal() {
    }

    public Animal(Date birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    /*
     * Getters et Setters
     * */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "birth=" + birth +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
