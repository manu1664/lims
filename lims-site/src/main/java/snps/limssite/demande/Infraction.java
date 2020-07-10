package snps.limssite.demande;

import lombok.Data;
import lombok.EqualsAndHashCode;
import snps.limssite.model.LibelleEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Infraction extends LibelleEntity {

    private String article;

    @ManyToOne
    @JoinColumn(name = "infraction_type_id")
    private InfractionType infractionType;

}
