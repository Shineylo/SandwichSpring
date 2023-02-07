package technobel.bart.sandwichspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import technobel.bart.sandwichspring.service.SandwichService;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;

    public SandwichController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    //GET - /sandwich/all
    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("liste",sandwichService.getAll());
        return "sandwich/display-all";
    }
}
