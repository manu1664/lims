package snps.lims.demande;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class DemandeRepositoryIntegrationTest {

    private static final int ID = 0;
    private static final String REFERENCE = "LPSDD-YYYY-XXXXX";

    private @Autowired DemandeRepository demandes;
    private Demande demande;

    @BeforeEach
    public void setUp() {
        Date now = new Date(System.currentTimeMillis());
        this.demande = new Demande();
        this.demande.setId(ID);
        this.demande.setEditionDate(now);
        this.demande.setReference(REFERENCE);
        this.demandes.save(this.demande);
    }

    @Test
    public void whenFindById_thenReturnOptionalDemande() {
        Optional<Demande> found = this.demandes.findById(ID);
        assertThat(found.isPresent()).isTrue();
    }

    @Test
    public void whenFindByReference_thenReturnReferenceList() {
        List<Demande> found = this.demandes.findByReference(REFERENCE);
        assertThat(found).contains(this.demande);
    }

}
