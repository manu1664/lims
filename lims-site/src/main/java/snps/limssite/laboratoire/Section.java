package snps.limssite.laboratoire;

import lombok.Data;
import lombok.EqualsAndHashCode;
import snps.limssite.model.LibelleEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Section extends LibelleEntity {

    private String code;
    private String description;
    private boolean actif;


}
