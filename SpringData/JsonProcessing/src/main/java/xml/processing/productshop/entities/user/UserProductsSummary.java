package xml.processing.productshop.entities.user;

import xml.processing.productshop.entities.product.ProductsSummary;

public class UserProductsSummary {
    private String firstName;
    private String lastName;
    private int age;
    private ProductsSummary soldProducts;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public ProductsSummary getSoldProducts() {
        return soldProducts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSoldProducts(ProductsSummary soldProducts) {
        this.soldProducts = soldProducts;
    }
}
