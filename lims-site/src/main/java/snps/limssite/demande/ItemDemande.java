package snps.limssite.demande;

import snps.limssite.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "item_demande")
public class ItemDemande extends BaseEntity {

    private String status;

    @Column(name = "ordre_passage")
    private int ordrePassage;

    @ManyToOne
    @JoinColumn(name = "demande_id")
    private Demande demande;

    @ManyToOne
    @JoinColumn(name = "analyse_id")
    private Analyse analyse;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrdrePassage() {
        return ordrePassage;
    }

    public void setOrdrePassage(int ordrePassage) {
        this.ordrePassage = ordrePassage;
    }

    public Analyse getAnalyse() {
        return analyse;
    }

    public void setAnalyse(Analyse analyse) {
        this.analyse = analyse;
    }
}
