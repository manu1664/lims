package snps.limssite.demande;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import snps.limssite.model.BaseEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "non_conformite")
public class NonConformite extends BaseEntity {

    private String motif;

    private String status;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "demande_id")
    private Demande demande;

    @OneToMany(mappedBy = "nonConformite")
    @Fetch(FetchMode.JOIN)
    private Set<NonConformiteNote> nonConformiteNotes;


    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public Set<NonConformiteNote> getNonConformiteNotes() {
        return nonConformiteNotes;
    }

    public void setNonConformiteNotes(Set<NonConformiteNote> nonConformiteNotes) {
        this.nonConformiteNotes = nonConformiteNotes;
    }
}
