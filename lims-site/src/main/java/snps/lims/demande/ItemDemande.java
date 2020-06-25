package snps.lims.demande;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "item_demande")
public class ItemDemande {

    @Id
    private int id;

    private String status;

    @Column(name = "ordre_passage")
    private int ordrePassage;

    @Column(name = "demande_id")
    private int demandeId;

    @ManyToOne
    @JoinColumn(name = "analyse_id")
    private Analyse analyse;

}
