package snps.lims.demande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemandeController {

    @Autowired
    private DemandeRepository demandes;

    @GetMapping("/demande/list")
    public String showAll(Model model) {
        model.addAttribute("demandes", this.demandes.findAll());
        return "demande/list";
    }

}
