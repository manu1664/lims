package snps.limssite.demande;

import snps.limssite.model.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Affaire extends BaseEntity {

    private String numeroPv;
    private String description;

    public String getNumeroPv() {
        return numeroPv;
    }

    public void setNumeroPv(String numeroPv) {
        this.numeroPv = numeroPv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
