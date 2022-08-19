package bg.softuni.mobilele.web;

import bg.softuni.mobilele.services.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String getAllBrands(Model model) {
        if (!model.containsAttribute("brands")) model.addAttribute("brands", brandService.findAllBrands());
        return "brands";
    }
}
