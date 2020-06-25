package snps.lims.requerant;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class Service {

    @Id
    private int id;
    private String libelle;
    private String adresse;
    private String codePostal;
    private String ville;


}
