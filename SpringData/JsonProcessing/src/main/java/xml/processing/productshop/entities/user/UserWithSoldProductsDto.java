package xml.processing.productshop.entities.user;

import xml.processing.productshop.entities.product.SoldProductDto;

import java.util.List;

public class UserWithSoldProductsDto {
    private String firstName;
    private String lastName;
    private List<SoldProductDto> soldProducts;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SoldProductDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProductDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
