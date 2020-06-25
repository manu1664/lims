package snps.limssite.demande;

import lombok.Data;
import snps.limssite.requerant.Requerant;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
public class Demande {

    @Id
    private int id;

    private String reference;
    private Date editionDate;

    @ManyToOne
    @JoinColumn(name = "requerant_id")
    private Requerant requerant;

    @ManyToMany
    private Set<Affaire> affaires;

}
