package snps.limssite.requerant;

import snps.limssite.model.LibelleEntity;

import javax.persistence.*;

@Entity
public class Service extends LibelleEntity {

    private String adresse;
    private String codePostal;
    private String ville;
    private String status;

    @ManyToOne
    @JoinColumn(name = "service_history_id", foreignKey = @ForeignKey(name = "fk_service_service_history"))
    private ServiceHistory serviceHistory;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
