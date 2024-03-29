package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.Offer;
import bg.softuni.mobilele.models.dtos.AddOfferDto;
import bg.softuni.mobilele.models.dtos.AllOfferDto;
import bg.softuni.mobilele.models.dtos.BrandDto;
import bg.softuni.mobilele.models.dtos.SearchOfferDto;
import bg.softuni.mobilele.services.BrandService;
import bg.softuni.mobilele.services.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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


    @ModelAttribute("brandList")
    public List<BrandDto> brandList() {
        return brandService.findAllBrandsDtos();
    }

    @GetMapping("/add")
    public String getAdd(Model model) {
        if (!model.containsAttribute("addOfferDto"))
            model.addAttribute("addOfferDto", new AddOfferDto());
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

    @GetMapping("/all")
    public String getAll(Model model, @PageableDefault(
            sort = "price",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 20) Pageable pageable,
                         SearchOfferDto searchOfferDto) {
        if (!searchOfferDto.isEmpty()) {
            model.addAttribute("offers", offerService.findAllOfferDtos(pageable, searchOfferDto));
        } else {
            model.addAttribute("offers", offerService.findAllOfferDtos(pageable));
        }

        return "offers";
    }

    @GetMapping("/{id}")
    public String getDetails(@PathVariable long id, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("isOwner", offerService.isOwner(userDetails, id));
        model.addAttribute("offer", offerService.findOfferDetailsDto(id));
        return "details";
    }

    @GetMapping("/{id}/update")
    @PreAuthorize("@offerService.isOwner(#userDetails, #id)")
    public String getUpdate(@PathVariable long id, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Offer offerById = offerService.findOfferById(id);
        if (!model.containsAttribute("addOfferDto"))
            model.addAttribute("addOfferDto", new AddOfferDto(offerById));
        model.addAttribute("id", id);
        return "update";
    }

    @PutMapping("/{id}")
    @PreAuthorize("@offerService.isOwner(#userDetails, #id)")
    public String updateOffer(@PathVariable long id, @Valid AddOfferDto addOfferDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDto", bindingResult);
            return "redirect:/offers/" + id + "/update";
        }
        offerService.updateOffer(id, addOfferDto);
        return "redirect:/offers/" + id;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@offerService.isOwner(#userDetails, #id)")
    public String deleteOffer(@PathVariable long id, @AuthenticationPrincipal UserDetails userDetails) {
        offerService.deleteOffer(id);
        return "redirect:/offers/all";
    }

}
