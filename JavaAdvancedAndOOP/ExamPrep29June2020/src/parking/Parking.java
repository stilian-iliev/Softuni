package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > data.size()) data.add(car);
    }

    public boolean remove(String manufacturer, String model) {
        Car car = getCar(manufacturer, model);
        return data.remove(car);
    }

    public Car getLatestCar() {
        return data.stream()
                .max((f, s) -> Integer.compare(f.getYear(), s.getYear()))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        return String.format("The cars are parked in %s:%n%s"
                , type
                , data.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator())))
                .trim();
    }
}
