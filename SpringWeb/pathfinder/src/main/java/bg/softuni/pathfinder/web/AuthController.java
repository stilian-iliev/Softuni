package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.models.dtos.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        return "redirect:/";
    }

    @ModelAttribute("userRegisterDto")
    public UserRegisterDto userRegisterDto() {
        return new UserRegisterDto();
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto, BindingResult bindingResult) {
        //todo register login about and profile
        //if pass dont match add error
        //if user exists add error
        if (bindingResult.hasErrors()) {
            return "redirect:/register";
        }
        System.out.println(userRegisterDto);
        return "redirect:/login";
    }
}
