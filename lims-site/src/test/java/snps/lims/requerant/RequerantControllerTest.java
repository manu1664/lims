package snps.lims.requerant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RequerantController.class)
public class RequerantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RequerantRepository requerants;

    @Test
    public void showRequerantList() throws Exception {
        given(this.requerants.findAll()).willReturn(Arrays.asList(new Requerant()));
        given(this.requerants.count()).willReturn(999L);

        this.mockMvc
                .perform(get("/requerant/list"))
                .andExpect(view().name("requerant/list"))
                .andExpect(model().attributeExists("requerantList", "requerantLength"))
                .andExpect(status().isOk());
    }

    @Test
    public void showRequerantDetails() throws Exception {
        Requerant requerant = new Requerant();
        requerant.setPrenom("Jean");
        requerant.setNom("Micahle");
        given(this.requerants.findById(anyInt())).willReturn(Optional.of(requerant));

        this.mockMvc
                .perform(get("/requerant/{id}", 1))
                .andExpect(status().isOk());
    }

}
