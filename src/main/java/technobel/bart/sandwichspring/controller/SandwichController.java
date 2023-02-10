package technobel.bart.sandwichspring.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import technobel.bart.sandwichspring.models.dto.SandwichDTO;
import technobel.bart.sandwichspring.models.form.sandwich.SandwichInsertForm;
import technobel.bart.sandwichspring.models.form.sandwich.SandwichUpdateForm;
import technobel.bart.sandwichspring.service.SandwichService;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;
    private final IngredientService ingredientService;

    public SandwichController(SandwichService sandwichService, IngredientService ingredientService) {
        this.sandwichService = sandwichService;
        this.ingredientService = ingredientService;
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
        model.addAttribute("ingredients", ingredientService.getAll());
        return "sandwich/insert-form";
    }

    @PostMapping("/add")
    public String processInsertForm(@ModelAttribute("form") @Valid SandwichInsertForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors() ) {
            return "sandwich/insert-form";
        }

        sandwichService.insert(form);
        return "redirect:/sandwich/all";
    }

    @GetMapping("/{id:[0-9]+}/update")
    public String updateForm(Model model, @PathVariable long id){
        SandwichUpdateForm form = new SandwichUpdateForm();

        SandwichDTO sandwich = sandwichService.getOne(id);
        form.setName( sandwich.getName() );
        form.setDesc( sandwich.getDesc() );
        form.setPrice( sandwich.getPrice() );
        form.setIngredientsId(
                sandwich.getIngredients().stream()
                        .map(IngredientDTO::getId)
                        .toList()
        );

        model.addAttribute("form", form);
        model.addAttribute("id", id);
        model.addAttribute("ingredients",ingredientService.getAll());

        return "sandwich/update-form";
    }

    @PostMapping("/{id:[0-9]+}/update")
    public String processUpdateForm(
            @PathVariable Long id,
            @ModelAttribute("form") @Valid SandwichUpdateForm form,
            BindingResult bindingResult
    ){
        if( bindingResult.hasErrors() ){
            return "sandwich/update-form";
        }

        sandwichService.update(id, form);
        return "redirect:/sandwich/"+id;
    }

}
