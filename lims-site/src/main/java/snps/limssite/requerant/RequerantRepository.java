package snps.limssite.requerant;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RequerantRepository  extends CrudRepository<Requerant, Integer> {

    List<Requerant> findByNom(String nom);

    List<Requerant> findByService_Libelle(String libelle);

}
