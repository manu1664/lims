package snps.lims.laboratoire;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Section {

    @Id
    private int id;
    private String code;
    private String libelle;
    private String description;
    private boolean actif;


}
