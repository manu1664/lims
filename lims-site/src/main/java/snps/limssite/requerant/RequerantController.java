package snps.limssite.requerant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RequerantController {

    @Autowired
    private RequerantRepository requerants;

    @GetMapping("/requerant/list")
    public String showRequerantList(Model model) {
        model
                .addAttribute("requerantList", this.requerants.findAll())
                .addAttribute("requerantLength", this.requerants.count());
        return "requerant/list";
    }


    @GetMapping("/requerant/{id}")
    public String showDetails(@PathVariable("id") int id, Model model) {
        this.requerants.findById(id).ifPresent(
                requerant -> model.addAttribute("requerant", requerant)
        );
        return "requerant/details";
    }

}
