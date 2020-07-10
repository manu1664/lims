package snps.limssite.demande;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import snps.limssite.model.BaseEntity;
import snps.limssite.requerant.Requerant;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Demande extends BaseEntity {

    private String reference;
    private Date editionDate;
    private Date receptionDate;

    @ManyToOne
    @JoinColumn(name = "requerant_id")
    private Requerant requerant;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "demande_affaire",
            joinColumns = @JoinColumn(name = "affaire_id"),
            inverseJoinColumns = @JoinColumn(name = "demande_id"))
    private Set<Affaire> affaires;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "demande_infraction",
            joinColumns = @JoinColumn(name = "demande_id"),
            inverseJoinColumns = @JoinColumn(name = "infraction_id"))
    private Set<Infraction> infractions = new HashSet<>();


    @OneToMany(mappedBy = "demande", fetch = FetchType.EAGER)
    private Set<ItemDemande> itemDemandes;

    @OneToMany(mappedBy = "demande", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<NonConformite> nonConformites;


    public Set<NonConformite> getNonConformites() {
        return nonConformites;
    }

    public void setNonConformites(Set<NonConformite> nonConformites) {
        this.nonConformites = nonConformites;
    }

    public Set<ItemDemande> getItemDemandes() {
        return getItemDemandesInternal();
    }

    private Set<ItemDemande> getItemDemandesInternal() {
        if(this.itemDemandes == null) {
            this.itemDemandes = new HashSet<>();
        }
        return this.itemDemandes;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(Date editionDate) {
        this.editionDate = editionDate;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public Requerant getRequerant() {
        return requerant;
    }

    public void setRequerant(Requerant requerant) {
        this.requerant = requerant;
    }

    public Set<Affaire> getAffaires() {
        return affaires;
    }

    public void setAffaires(Set<Affaire> affaires) {
        this.affaires = affaires;
    }

    public Set<Infraction> getInfractions() {
        return infractions;
    }

    public void setInfractions(Set<Infraction> infractions) {
        this.infractions = infractions;
    }

    public void setItemDemandes(Set<ItemDemande> itemDemandes) {
        this.itemDemandes = itemDemandes;
    }
}
