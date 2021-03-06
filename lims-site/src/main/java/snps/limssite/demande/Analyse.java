package snps.limssite.demande;

import lombok.Data;
import lombok.EqualsAndHashCode;
import snps.limssite.laboratoire.Section;
import snps.limssite.model.LibelleEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Analyse extends LibelleEntity {

    private String description;
    private Double prix;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

}
