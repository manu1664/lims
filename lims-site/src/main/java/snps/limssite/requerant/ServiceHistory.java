package snps.limssite.requerant;

import snps.limssite.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ServiceHistory extends BaseEntity {

    @OneToMany(mappedBy = "serviceHistory")
    private Set<Service> services;


    public Set<Service> getServices() {
        return this.getServicesInternal();
    }

    private Set<Service> getServicesInternal() {
        if(this.services == null) {
            this.services = new HashSet<>();
        }
        return this.services;
    }

    public void addService(Service service) {
        this.getServicesInternal().add(service);
    }
}

