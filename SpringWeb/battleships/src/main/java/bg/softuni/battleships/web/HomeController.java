package bg.softuni.battleships.web;

import bg.softuni.battleships.models.Ship;
import bg.softuni.battleships.services.ShipService;
import bg.softuni.battleships.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    private CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String home() {
        return currentUser.isActive() ? "redirect:/home" : "index";
    }

}
