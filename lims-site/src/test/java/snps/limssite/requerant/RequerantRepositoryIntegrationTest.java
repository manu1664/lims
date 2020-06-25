package snps.limssite.requerant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RequerantRepositoryIntegrationTest {

    private static final int ID = 0;
    private static final String NOM = "Demol";
    private static final String EMAIL = "jurgen.demol@mail.com";
    private static final String LIBELLE_SERVICE = "SP LILLE";

    @Autowired
    private RequerantRepository requerants;

    @Autowired
    private ServiceRepository services;

    private Requerant requerant;

    @BeforeEach
    public void setUp() {
        Service service = new Service();
        service.setId(ID);
        service.setLibelle(LIBELLE_SERVICE);
        service.setAdresse("12, rue de la Police");
        service.setCodePostal("12345");
        service.setVille("City Town");
        this.services.save(service);

        this.requerant = new Requerant();
        this.requerant.setId(ID);
        this.requerant.setNom(NOM);
        this.requerant.setPrenom("Jurgen");
        this.requerant.setEmail(EMAIL);
        this.requerant.setGrade("Chef");
        this.requerant.setService(service);

        this.requerants.save(this.requerant);
    }

    @Test
    public void whenFindById_thenReturnRequerantInstance() {
        Optional<Requerant> found = this.requerants.findById(ID);

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getEmail()).isEqualTo(EMAIL);
    }

    @Test
    public void whenFindByNom_thenReturnRequerantList() {
        List<Requerant> found = this.requerants.findByNom(NOM);
        assertThat(found).contains(this.requerant);
    }

    @Test
    public void whenFindByService_thenReturnRequerantList() {
        List<Requerant> found = this.requerants.findByService_Libelle(LIBELLE_SERVICE);
        assertThat(found).isNotEmpty();
    }

}
