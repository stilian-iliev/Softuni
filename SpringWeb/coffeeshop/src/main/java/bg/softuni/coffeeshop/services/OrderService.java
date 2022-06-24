package bg.softuni.coffeeshop.services;

import bg.softuni.coffeeshop.models.Category;
import bg.softuni.coffeeshop.models.Order;
import bg.softuni.coffeeshop.models.User;
import bg.softuni.coffeeshop.models.dtos.AddOrderDto;
import bg.softuni.coffeeshop.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CategoryService categoryService;
    private final ModelMapper mapper;

    public OrderService(OrderRepository orderRepository, CategoryService categoryService, ModelMapper mapper) {
        this.orderRepository = orderRepository;
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    public void add(AddOrderDto addOrderDto, User employee) {
        Order order = mapper.map(addOrderDto, Order.class);
        Category category = categoryService.findById(addOrderDto.getCategory());
        order.setEmployee(employee);
        order.setCategory(category);
        orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void deleteById(UUID orderId) {
        orderRepository.deleteById(orderId);
    }
}
