package snps.limssite.requerant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ServiceHistoryRepositoryIntegrationTest {

    private static final int ID = 0;
    private static final int SERVICE_DEUX_ID = 2;

    @Autowired
    private ServiceHistoryRepository serviceHistories;

    @BeforeEach
    public void setUp() {
        Service s1 = new Service();
        s1.setId(1);
        s1.setAdresse("1 rue du prout");
        s1.setCodePostal("01000");
        s1.setVille("UN");
        s1.setStatus("DISABLE");

        Service s2 = new Service();
        s1.setId(SERVICE_DEUX_ID);
        s1.setAdresse("2 rue du prout");
        s1.setCodePostal("02000");
        s1.setVille("DEUX");
        s1.setStatus("ENABLE");

        ServiceHistory history = new ServiceHistory();
        history.setId(ID);
        history.addService(s1);
        history.addService(s2);
        this.serviceHistories.save(history);
    }

    @Test
    public void whenFindById_returnServiceHistory() {
        Optional<ServiceHistory> found = this.serviceHistories.findById(ID);
        found.ifPresent(
                history -> assertThat(history.getServices().size()).isEqualTo(2)
        );
    }

}
