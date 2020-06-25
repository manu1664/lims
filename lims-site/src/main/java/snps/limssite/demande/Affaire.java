package snps.limssite.demande;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Affaire {

    @Id
    private int id;

    private String numeroPv;
    private String description;

}
