package snps.lims.demande;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import snps.lims.requerant.Requerant;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DemandeController.class)
public class DemandeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DemandeRepository demandeRepository;

    private Demande demande;

    @BeforeEach
    public void setUp() {
        this.demande = new Demande();
        this.demande.setId(0);
        this.demande.setReference("LPSDD-YYYY-XXXXX");
        this.demande.setRequerant(new Requerant());
        this.demande.setAffaires(Stream.of(new Affaire()).collect(Collectors.toSet()));
    }


    @Test
    public void showDemandeList() throws Exception {
        given(this.demandeRepository.findAll()).willReturn(Arrays.asList(this.demande));

        this.mvc
                .perform(
                        get("/demande/list")
                )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("demandes"))
                .andExpect(view().name("demande/list"));
    }

}
