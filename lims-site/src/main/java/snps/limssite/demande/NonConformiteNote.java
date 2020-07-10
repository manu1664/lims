package snps.limssite.demande;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import snps.limssite.model.BaseEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "non_conformite_note")
public class NonConformiteNote extends BaseEntity {

    @Column(name = "edition_date")
    private Date editionDate;

    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "non_conformite_id")
    private NonConformite nonConformite;

    public Date getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(Date editionDate) {
        this.editionDate = editionDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NonConformite getNonConformite() {
        return nonConformite;
    }

    public void setNonConformite(NonConformite nonConformite) {
        this.nonConformite = nonConformite;
    }
}
