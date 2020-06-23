package snps.lims.demande;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends CrudRepository<Demande, Integer> {

    /**
     * Retrieve the {@link Demande}s from the data store by the reference.
     * @param reference of a {@link Demande}
     * @return a list of {@link Demande}s
     */
    List<Demande> findByReference(String reference);
}
