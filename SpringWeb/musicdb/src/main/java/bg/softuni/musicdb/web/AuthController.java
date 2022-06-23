package bg.softuni.musicdb.web;


import bg.softuni.musicdb.models.dtos.LoginDto;
import bg.softuni.musicdb.models.dtos.UserRegisterDto;
import bg.softuni.musicdb.services.AuthService;
import bg.softuni.musicdb.session.CurrentUser;
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
    private final CurrentUser currentUser;

    public AuthController(AuthService authService, CurrentUser currentUser) {
        this.authService = authService;
        this.currentUser = currentUser;
    }

    @ModelAttribute("userRegisterDto")
    public UserRegisterDto userRegisterDto() {
        return new UserRegisterDto();
    }

    @GetMapping("/register")
    public String getRegister() {
        if (currentUser.isActive()) return "redirect:/";
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (currentUser.isActive()) return "redirect:/";

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto", bindingResult);
            return "redirect:/register";
        }
        authService.register(userRegisterDto);
        return "redirect:/";
    }

    @ModelAttribute("loginDto")
    public LoginDto loginDto() {
        return new LoginDto();
    }

    @GetMapping("/login")
    public String getLogin() {
        if (currentUser.isActive()) return "redirect:/";
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDto loginDto,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (currentUser.isActive()) return "redirect:/";

        if (!authService.login(loginDto)) bindingResult.addError(new ObjectError("no such user", "no such user"));
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDto", loginDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDto", bindingResult);
            return "redirect:/login";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        authService.logout();
        return "redirect:/";
    }
}
