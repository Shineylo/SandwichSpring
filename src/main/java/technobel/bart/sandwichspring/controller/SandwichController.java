package technobel.bart.sandwichspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import technobel.bart.sandwichspring.models.form.SandwichInsertForm;
import technobel.bart.sandwichspring.service.SandwichService;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;

    public SandwichController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    // GET - /sandwich/all
    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("list", sandwichService.getAll());
        return "sandwich/display-all";
    }

    @GetMapping("/{id:[0-9]+}")
    public String getOne(Model model, @PathVariable long id){
        model.addAttribute( "sandwich", sandwichService.getOne(id) );
        return "sandwich/display-one";
    }

    @GetMapping("/add")
    public String insertForm(Model model){
        model.addAttribute("form", new SandwichInsertForm());
        return "sandwich/insert-form";
    }

    @PostMapping("/add")
    public String processInsertForm(SandwichInsertForm form){
        sandwichService.insert(form);
        return "redirect:/sandwich/all";
    }

}
