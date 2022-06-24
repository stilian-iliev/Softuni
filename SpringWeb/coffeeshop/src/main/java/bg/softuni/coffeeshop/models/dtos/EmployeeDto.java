package bg.softuni.coffeeshop.models.dtos;

import bg.softuni.coffeeshop.models.User;

public class EmployeeDto {
    private String fullName;
    private int ordersCount;

    public EmployeeDto(User user) {
        this.fullName = user.getFirstName() + " " + user.getLastName();
        this.ordersCount = user.getOrders().size();
    }

    public String getFullName() {
        return fullName;
    }

    public int getOrdersCount() {
        return ordersCount;
    }
}
