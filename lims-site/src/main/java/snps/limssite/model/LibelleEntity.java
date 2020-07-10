package snps.limssite.model;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class LibelleEntity extends BaseEntity {

    @Column(name = "libelle")
    private String libelle;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return this.getLibelle();
    }
}
