package snps.limssite.requerant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ServiceRepositoryIntegrationTest {

    private static final int ID = 99999;

    @Autowired
    private ServiceRepository services;

    private Service service;

    @BeforeEach
    public void setUp() {
        this.service = new Service();
        this.service.setId(ID);
        this.service.setLibelle("SP BRUSSELS");
        this.service.setCodePostal("1000");
        this.service.setVille("BRUSSELS");
        this.service.setAdresse("Grand-Place");
        this.services.save(this.service);
    }

    @Test
    public void whenFindById_thenReturnOptionalService() {
        Optional<Service> found = this.services.findById(ID);
        assertThat(found.isPresent()).isTrue();
    }

}
