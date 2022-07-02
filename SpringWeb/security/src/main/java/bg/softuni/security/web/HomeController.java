package bg.softuni.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/all")
    public String getAll() {
        return "all";
    }

    @GetMapping("/moderator")
    public String getModerator() {
        return "moderators";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admins";
    }
}
