package epsi.b3.banque;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {
    private String beneficiaire;

    public Virement() {
    }
}
