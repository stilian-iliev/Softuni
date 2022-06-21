package bg.softuni.linkedout.web;

import bg.softuni.linkedout.models.dtos.CompanyAddDto;
import bg.softuni.linkedout.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/add")
    public String getAdd(Model model) {
        if (!model.containsAttribute("companyAddDto")) {
            model.addAttribute("companyAddDto", new CompanyAddDto());
        }
        return "company-add";
    }

    @PostMapping("/add")
    public String add(@Valid CompanyAddDto companyAddDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("companyAddDto", companyAddDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.companyAddDto", bindingResult);
            return "redirect:/companies/add";
        }
        companyService.add(companyAddDto);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        if (!model.containsAttribute("companies")) {
            model.addAttribute("companies", companyService.getAll());
        }
        return "company-all";
    }

    @GetMapping("/{companyId}")
    public String getCompanyDetails(@PathVariable("companyId") UUID companyId, Model model){
        model.addAttribute("company", companyService.getById(companyId));
        return "company-details";
    }

    @GetMapping("/{companyId}/delete")
    public String deleteCompany(@PathVariable("companyId") UUID companyId) {
        companyService.delete(companyId);
        return "redirect:/companies/all";
    }
}
