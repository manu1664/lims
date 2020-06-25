package snps.limssite.demande;

import lombok.Data;
import snps.limssite.laboratoire.Section;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Analyse {

    @Id
    private int id;

    private String libelle;
    private String description;
    private Double prix;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

}
