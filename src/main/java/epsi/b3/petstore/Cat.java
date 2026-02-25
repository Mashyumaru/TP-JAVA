package epsi.b3.petstore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Cat extends Animal {
    @Column(name = "chipId")
    private String chipId;

    public Cat() {
    }

    public Cat(Date birth, String couleur, PetStore petStore, String chipId) {
        super(birth, couleur, petStore);
        this.chipId = chipId;
    }

}
