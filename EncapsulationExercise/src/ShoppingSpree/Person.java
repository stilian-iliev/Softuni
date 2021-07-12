package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().length() == 0) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) throw new IllegalArgumentException("Money cannot be negative");
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money >= product.getCost()){
            System.out.printf("%s bought %s%n",name,product.getName());
            products.add(product);
            money -= product.getCost();
        }
        else throw new IllegalArgumentException(String.format("%s can't afford %s%n", name, product.getName()));
    }

    public String getName() {
        return name;
    }

    public List<Product> cart(){
        return Collections.unmodifiableList(products);
    }
}
