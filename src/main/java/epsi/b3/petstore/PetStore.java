package epsi.b3.petstore;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "PetStore")
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "managerName")
    private String managerName;

    @ManyToMany
    @JoinTable(name="PetStore_Product",
            joinColumns= @JoinColumn(name="PetStore_id", referencedColumnName=
                    "id"),
            inverseJoinColumns= @JoinColumn(name="Product_id", referencedColumnName=
                    "id")
    )
    private Set<Product> products;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "petStore")
    private Set<Animal> animals;


    /*
     * Constructeurs
     * */

    public PetStore() {
    }

    public PetStore(String name, String managerName, Set<Product> products, Address address, Set<Animal> animals) {
        this.name = name;
        this.managerName = managerName;
        this.products = products;
        this.address = address;
        this.animals = animals;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
}
