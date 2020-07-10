package snps.limssite.system;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping("/")
    public String redictToDemandeSearch() {
        return "redirect:/demande/search";
    }

}
