package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle{
    @Column(name = "load_capacity")
    private double loadCapacity;

    @ManyToMany
    private Set<Driver> drivers;

    public Truck() {}

    public Truck(String type, String model, BigDecimal price, String fuelType) {
        super(type, model, price, fuelType);
    }
}
