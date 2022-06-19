package bg.softuni.battleships.web;

import bg.softuni.battleships.models.Ship;
import bg.softuni.battleships.models.dtos.ShipAttackDto;
import bg.softuni.battleships.services.ShipService;
import bg.softuni.battleships.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BattleController {
    private final ShipService shipService;
    private final CurrentUser currentUser;

    public BattleController(ShipService shipService, CurrentUser currentUser) {
        this.shipService = shipService;
        this.currentUser = currentUser;
    }

    @GetMapping("/home")
    public String getHome() {
        if (!currentUser.isActive()) {
            return "redirect:/";
        }
        return "home";
    }

    @PostMapping("/home")
    public String attack(@Valid ShipAttackDto shipAttackDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/home";
        shipService.attack(shipAttackDto);
        return "redirect:/home";
    }


    @ModelAttribute("currentUserShips")
    public List<Ship> currentUserShips() {
        return shipService.getCurrentUserShips();
    }

    @ModelAttribute("otherUsersShips")
    public List<Ship> otherUsersShips() {
        return shipService.getOtherUsersShips();
    }

    @ModelAttribute("allShips")
    public List<Ship> allShips() {
        return shipService.getAllShips();
    }

    @ModelAttribute("shipAttackDto")
    public ShipAttackDto shipAttackDto() {
        return new ShipAttackDto();
    }
}
