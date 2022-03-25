package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle{
    @Column(name = "passenger_capacity")
    private int passengerCapacity;

    @ManyToOne
    private Company company;

    public Plane() {}

    public Plane(String type, String model, BigDecimal price, String fuelType) {
        super(type, model, price, fuelType);
    }
}
