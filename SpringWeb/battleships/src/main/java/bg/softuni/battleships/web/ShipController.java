package bg.softuni.battleships.web;

import bg.softuni.battleships.models.Category;
import bg.softuni.battleships.models.dtos.AddShipDto;
import bg.softuni.battleships.reposiotories.CategoryRepository;
import bg.softuni.battleships.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ShipController {
    private CategoryRepository categoryRepository;
    private final ShipService shipService;

    public ShipController(CategoryRepository categoryRepository, ShipService shipService) {
        this.categoryRepository = categoryRepository;
        this.shipService = shipService;
    }

    @ModelAttribute("addShipDto")
    public AddShipDto addShipDto(){
        return new AddShipDto();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/add")
    public String getAdd() {
        return "ship-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddShipDto addShipDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        //todo validate ship
        //todo show errors
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addShipDto", addShipDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addShipDto", bindingResult);
            return "redirect:/add";
        }
        shipService.addShip(addShipDto);

        return "redirect:/";
    }
}
