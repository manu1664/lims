package snps.limssite.demande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Controller
public class DemandeController {

    @Autowired
    private DemandeRepository demandes;

    @GetMapping("/demande/list")
    public String showAll(Model model) {
        model.addAttribute("demandes", this.demandes.findAll());
        return "demande/list";
    }

    @GetMapping("/demande/search")
    public String initFindDemande(Model model) {
        model.addAttribute("demande", new Demande());
        return "demande/search";
    }

    @GetMapping("/demandes")
    public String processFindDemande(Demande demande, BindingResult result, Model model) {

        if(demande.getReference() == null) {
            demande.setReference("");
        }

        Collection<Demande> results = this.demandes.findDemandeByReferenceContains(demande.getReference().toUpperCase());

        if(results.isEmpty()) {
            result.rejectValue("reference", "notFound", "notFound");
        } else {
            model.addAttribute("demandes", results);
        }
        return "demande/search";
    }


    @GetMapping("/demande/{id}")
    public String showDetails(@PathVariable("id") int id, Model model) {
        this.demandes.findById(id).ifPresent(
                demande -> model.addAttribute("demande", demande)
        );
        return "demande/details";
    }

}
