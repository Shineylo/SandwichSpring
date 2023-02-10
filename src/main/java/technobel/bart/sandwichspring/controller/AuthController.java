package technobel.bart.sandwichspring.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import technobel.bart.sandwichspring.models.form.user.RegisterForm;
import technobel.bart.sandwichspring.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    public String registerForm(@ModelAttribute("form") RegisterForm form){
        return "auth/register-form";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("form") @Valid RegisterForm form, BindingResult bindingResult){
        if( bindingResult.hasErrors() ){
            form.setPassword(null);
            return "auth/register-form";
        }

        authService.register(form);
        return "redirect:/";
    }
}
