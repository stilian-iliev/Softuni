package HealthyHeaven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Salad {
    private List<Vegetable> products;
    private String name;

    public Salad(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        return products.stream().mapToInt(Vegetable::getCalories).sum();
    }

    public int getProductCount() {
        return products.size();
    }

    public void add(Vegetable product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return String.format("* Salad %s is %d calories and have %d products:%n%s"
                , name
                , this.getTotalCalories()
                , this.getProductCount(), products.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
