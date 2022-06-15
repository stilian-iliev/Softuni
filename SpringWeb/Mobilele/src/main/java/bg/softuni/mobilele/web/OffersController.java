package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.Brand;
import bg.softuni.mobilele.models.dtos.AddOfferDto;
import bg.softuni.mobilele.models.dtos.BrandDto;
import bg.softuni.mobilele.services.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private BrandService brandService;

    public OffersController(BrandService brandService) {
        this.brandService = brandService;
    }

    @ModelAttribute("addOfferDto")
    public AddOfferDto addOfferDto() {
        return new AddOfferDto();
    }

    @ModelAttribute("brandList")
    public List<BrandDto> brandList() {
        return brandService.findAllBrands();
    }

    @GetMapping("/add")
    public String getAdd() {
        return "offer-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddOfferDto addOfferDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
//            System.out.println("wrong");
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDto", bindingResult);
            return "redirect:/offers/add";
        }

        return "";
    }
}
