package snps.limssite.requerant;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@Entity
public class Requerant {

    @Id
    private int id;

    private String grade;
    private String prenom;
    private String nom;
    private String email;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

}
