package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.models.Order;
import bg.softuni.coffeeshop.models.dtos.EmployeeDto;
import bg.softuni.coffeeshop.services.OrderService;
import bg.softuni.coffeeshop.services.UserService;
import bg.softuni.coffeeshop.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final UserService userService;
    private OrderService orderService;

    public HomeController(CurrentUser currentUser, UserService userService, OrderService orderService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.orderService = orderService;
    }

    @ModelAttribute("employees")
    public List<EmployeeDto> employeeDtos() {
        return userService.getAllDtos();
    }

    @ModelAttribute("orders")
    public List<Order> orders() {
        return orderService.findAll();
    }

    @ModelAttribute("time")
    public int time() {
        return orderService.findAll()
                .stream()
                .mapToInt(e -> e.getCategory().getNeededTime())
                .sum();
    }

    @GetMapping("/")
    public String getHome() {
        return currentUser.isActive() ? "home" : "index";
    }
}
