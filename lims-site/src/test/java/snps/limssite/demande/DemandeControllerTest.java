package snps.limssite.demande;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import snps.limssite.requerant.Requerant;
import snps.limssite.requerant.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
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
        Affaire affaire = new Affaire();
        affaire.setId(0);
        affaire.setDescription("Description");
        affaire.setNumeroPv("YYYY/XXX");

        Service service = new Service();
        service.setLibelle("SP LILLE");
        Requerant requerant = new Requerant();
        requerant.setNom("du");
        requerant.setPrenom("du");
        requerant.setService(service);

        this.demande = new Demande();
        this.demande.setId(0);
        this.demande.setReference("LPSDD-YYYY-XXXXX");
        this.demande.setRequerant(requerant);
        this.demande.setAffaires(Stream.of(affaire).collect(Collectors.toSet()));
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


    @Test
    public void initFindDemande() throws Exception {
        this.mvc
                .perform(
                        get("/demande/search")
                )
                .andExpect(status().isOk())
                .andExpect(view().name("demande/search"));
    }

    @Test
    public void processFindDemande() throws Exception {
        given(this.demandeRepository.findDemandeByReferenceContains(anyString())).willReturn(Collections.singletonList(this.demande));

        this.mvc
                .perform(
                        get("/demandes", "reference=" + anyString())
                )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("demandes"))
                .andExpect(view().name("demande/search"));
    }

    @Test
    public void showDetails() throws Exception {
        given(this.demandeRepository.findById(anyInt())).willReturn(Optional.of(this.demande));

        this.mvc
                .perform(
                        get("/demande/{id}", 0)
                )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("demande"))
                .andExpect(view().name("demande/details"));
    }

}
