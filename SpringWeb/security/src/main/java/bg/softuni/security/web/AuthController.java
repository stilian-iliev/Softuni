package bg.softuni.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String getLogin() {
        return "auth-login";
    }

    @GetMapping("/register")
    public String  getRegister() {
        return "auth-register";
    }
}
