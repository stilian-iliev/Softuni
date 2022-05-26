package bg.softuni.market.services;

import java.math.BigDecimal;

public interface SellerService {
    void addSeller(String firstName, String lastName, int age, BigDecimal salary, String shopName);

    void setNewManager(String sellerFirstName, String sellerLastName, String managerFirstName, String managerLastName);
}
