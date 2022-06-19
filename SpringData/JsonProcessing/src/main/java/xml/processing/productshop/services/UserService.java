package xml.processing.productshop.services;

import xml.processing.productshop.entities.user.UserWithSoldProductsDto;
import xml.processing.productshop.entities.user.UsersProductsSummary;

import java.util.List;

public interface UserService {
    List<UserWithSoldProductsDto> findAllUsersWithSoldProducts();

    UsersProductsSummary findUsersSoldProductsSummary();
}
