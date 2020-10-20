package snps.limssite.requerant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

    private ServiceHistory serviceHistory;

    @BeforeEach
    public void setUp() {
        this.serviceHistory = new ServiceHistory();
    }

    @Test
    public void whenGetServices_returnEmptySet() {
        assertThat(this.serviceHistory.getServices()).isEmpty();
    }

    @Test
    public void whenAddServices_testIfAdded() {
        this.serviceHistory.addService(new Service());
        assertThat(this.serviceHistory.getServices().size()).isEqualTo(1);
    }

}
