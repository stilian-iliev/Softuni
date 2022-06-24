package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.models.Category;
import bg.softuni.coffeeshop.models.dtos.AddOrderDto;
import bg.softuni.coffeeshop.services.AuthService;
import bg.softuni.coffeeshop.services.CategoryService;
import bg.softuni.coffeeshop.services.OrderService;
import bg.softuni.coffeeshop.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {
    private final CategoryService categoryService;
    private OrderService orderService;
    private final CurrentUser currentUser;
    private final AuthService authService;

    public OrderController(CategoryService categoryService, OrderService orderService, CurrentUser currentUser, AuthService authService) {
        this.categoryService = categoryService;
        this.orderService = orderService;
        this.currentUser = currentUser;
        this.authService = authService;
    }

    @ModelAttribute("addOrderDto")
    public AddOrderDto addOrderDto() {
        return new AddOrderDto();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.getAll();
    }

    @GetMapping("/add")
    public String getAdd() {
        if (!currentUser.isActive()) return "redirect:/";
        return "order-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddOrderDto addOrderDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (!currentUser.isActive()) return "redirect:/login";

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOrderDto", addOrderDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOrderDto",bindingResult);
            return "redirect:/add";
        }

        orderService.add(addOrderDto, authService.findById(currentUser.getId()));

        return "redirect:/";
    }

    @GetMapping("/orders/{id}/done")
    public String finishOrder(@PathVariable("id") UUID orderId) {
        if (!currentUser.isActive()) return "redirect:/login";

        orderService.deleteById(orderId);
        return "redirect:/";
    }


}
