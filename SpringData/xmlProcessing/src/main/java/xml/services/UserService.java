package xml.services;

import xml.entities.user.UsersProductsCountListDto;
import xml.entities.user.UsersWithSoldProductsListDto;

public interface UserService {


    UsersWithSoldProductsListDto findAllWithSoldProducts();

    UsersProductsCountListDto findAllUsersProductsCount();
}
