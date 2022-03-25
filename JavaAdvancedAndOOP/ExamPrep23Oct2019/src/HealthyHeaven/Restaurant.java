package HealthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        data = new ArrayList<>();
    }

    public void add(Salad salad){
        data.add(salad);
    }

    public boolean buy(String name){
        Salad salad = data.stream().filter(e-> e.getName().equals(name)).findFirst().orElse(null);
        return data.remove(salad);
    }

    public Salad getHealthiestSalad(){
        return data.stream().min(Comparator.comparingInt(Salad::getTotalCalories)).orElse(null);
    }

    public String generateMenu(){
        return String.format("%s have %d salads:%n%s",name
                ,data.size()
                ,data.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}

