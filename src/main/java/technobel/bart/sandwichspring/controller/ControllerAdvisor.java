package technobel.bart.sandwichspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import technobel.bart.sandwichspring.exception.NotFoundException;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({NotFoundException.class})
    public String handle(NotFoundException ex, Model model, HttpServletRequest req){
        model.addAttribute("ex", ex);
        return "errors/demo-throw";
    }

}