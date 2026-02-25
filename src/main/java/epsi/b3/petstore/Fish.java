package epsi.b3.petstore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Fish extends Animal{
    @Column(name = "livingEnv")
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(Date birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }
}
