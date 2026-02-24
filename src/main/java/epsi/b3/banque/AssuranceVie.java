package epsi.b3.banque;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte{
    private double taux;
    private LocalDate dateFin;
}
