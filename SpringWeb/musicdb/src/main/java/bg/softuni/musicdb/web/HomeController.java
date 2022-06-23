package bg.softuni.musicdb.web;

import bg.softuni.musicdb.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String getHome() {
        if (currentUser.isActive()) return "redirect:/albums";
        return "index";
    }


}
