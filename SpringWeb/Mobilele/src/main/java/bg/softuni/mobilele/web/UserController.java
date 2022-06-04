package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.dtos.UserLoginDto;
import bg.softuni.mobilele.models.dtos.UserRegisterDto;
import bg.softuni.mobilele.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto) {
        if (userService.login(userLoginDto)) {
            return "redirect:/";
        }
        return "redirect:/users/login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegisterDto userRegisterDto) {
        userService.register(userRegisterDto);
        return "redirect:/users/login";
    }
}
