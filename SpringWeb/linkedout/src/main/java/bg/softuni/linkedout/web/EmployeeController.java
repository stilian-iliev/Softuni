package bg.softuni.linkedout.web;

import bg.softuni.linkedout.models.dtos.AddEmployeeDto;
import bg.softuni.linkedout.services.CompanyService;
import bg.softuni.linkedout.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private CompanyService companyService;
    private EmployeeService employeeService;

    public EmployeeController(CompanyService companyService, EmployeeService employeeService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String getAdd(Model model) {
        if (!model.containsAttribute("addEmployeeDto")) {
            model.addAttribute("addEmployeeDto", new AddEmployeeDto());
        }
        if (!model.containsAttribute("companies")) {
            model.addAttribute("companies", companyService.getAll());
        }
        return "employee-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddEmployeeDto addEmployeeDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addEmployeeDto", addEmployeeDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addEmployeeDto", bindingResult);
            return "redirect:/employees/add";
        }
        employeeService.add(addEmployeeDto);
        return "redirect:/";
    }

}
