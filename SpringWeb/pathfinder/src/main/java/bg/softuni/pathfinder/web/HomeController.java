package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.models.Route;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        Route mostCommented = routeService.getMostCommented();
        model.addAttribute("mostCommented", mostCommented);
        return "index";
    }
}
