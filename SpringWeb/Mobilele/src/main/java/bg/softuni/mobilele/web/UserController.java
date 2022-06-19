package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.dtos.UserLoginDto;
import bg.softuni.mobilele.models.dtos.UserRegisterDto;
import bg.softuni.mobilele.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        if (!model.containsAttribute("userLoginDto")){
            model.addAttribute("userLoginDto", new UserLoginDto());
        }
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (userService.login(userLoginDto)) {
            return "redirect:/";
        }

//        bindingResult.rejectValue("password", "");
        bindingResult.addError(new ObjectError("userLoginDto","No such user."));
        redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto", bindingResult);
        return "redirect:/users/login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        if (model.getAttribute("registerModel") == null)
            model.addAttribute("registerModel", new UserRegisterDto());
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerModel", userRegisterDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerModel", bindingResult);
            return "redirect:/users/register";
        }
        userService.register(userRegisterDto);
        return "redirect:/users/login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }
}
