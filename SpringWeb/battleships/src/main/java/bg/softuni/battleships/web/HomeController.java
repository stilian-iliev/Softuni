package bg.softuni.battleships.web;

import bg.softuni.battleships.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String home() {
        return currentUser.isActive() ? "home" : "index";
    }
}
