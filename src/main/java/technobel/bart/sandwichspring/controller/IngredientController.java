@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    public String displayAll(Model model){
        model.addAttribute("list", ingredientService.getAll());
        return "ingredient/display-all";
    }

    @GetMapping("/{id:[0-9]+}")
    public String displayOne(Model model, @PathVariable long id){
        model.addAttribute("ingredient", ingredientService.getOne(id));
        return "ingredient/display-one";
    }

    @PostMapping("/add")
    public String processAddIngredient(@RequestParam String name){
        ingredientService.insert(name);
        return "redirect:all";
    }

    @PostMapping("/{id:[0-9]+}/delete")
    public String processDeleteIngredient(@PathVariable long id){
        ingredientService.delete(id);
        return "redirect:/ingredient/all";
    }

}