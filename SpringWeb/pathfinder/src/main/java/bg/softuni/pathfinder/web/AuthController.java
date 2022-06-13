package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.models.dtos.UserLoginDto;
import bg.softuni.pathfinder.models.dtos.UserRegisterDto;
import bg.softuni.pathfinder.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute
    public UserLoginDto userLoginDto() {
        return new UserLoginDto();
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto, RedirectAttributes redirectAttributes) {
        if (authService.login(userLoginDto)) {
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
        return "redirect:/login";
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
    public String register(@Valid UserRegisterDto userRegisterDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        //todo register login about and profile
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            bindingResult.addError(new ObjectError("password", "Passwords don't match."));
        }
        if (authService.exists(userRegisterDto.getUsername())) {
            bindingResult.addError(new ObjectError("username", "Username is already occupied"));
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto", bindingResult);
            return "redirect:/register";
        }
        authService.register(userRegisterDto);
        return "redirect:/login";
    }
}
