package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.dtos.AddOfferDto;
import bg.softuni.mobilele.models.dtos.BrandDto;
import bg.softuni.mobilele.services.BrandService;
import bg.softuni.mobilele.services.OfferService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    private OfferService offerService;

    public OffersController(BrandService brandService, OfferService offerService) {
        this.brandService = brandService;
        this.offerService = offerService;
    }

    @ModelAttribute("addOfferDto")
    public AddOfferDto addOfferDto() {
        return new AddOfferDto();
    }

    @ModelAttribute("brandList")
    public List<BrandDto> brandList() {
        return brandService.findAllBrandsDtos();
    }

    @GetMapping("/add")
    public String getAdd() {
        return "offer-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddOfferDto addOfferDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDto", bindingResult);
            return "redirect:/offers/add";
        }

        offerService.add(addOfferDto, userDetails);

        return "redirect:/";
    }
}
