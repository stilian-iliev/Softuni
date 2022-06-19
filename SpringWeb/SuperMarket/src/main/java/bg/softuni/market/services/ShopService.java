package bg.softuni.market.services;

public interface ShopService {
    void addShop(String name, String address, String town);

    void showAllSellers(String name);

    void showAllProducts(String name);
}
