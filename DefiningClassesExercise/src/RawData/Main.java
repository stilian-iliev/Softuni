package RawData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            cars.put(model, new Car(model, new Engine(speed, power), new Cargo(cargoWeight, cargoType), new ArrayList<>()));
            for (int i = 5; i < 10; i += 2) {
                double pressure = Double.parseDouble(input[i]);
                int age = Integer.parseInt(input[i+1]);
                cars.get(model).putTire(age, pressure);
            }
        }

        String criteria = sc.nextLine();
        //if fragile = "fragile" && tirePressure < 1
        //if flammable = "flamable" && enginePower > 250

        Predicate<Car> fragile = e -> e.getCargo().getType().equals("fragile");
        Predicate<Car> tireUnderOne = e -> {
            for (Tire tire : e.getTires()) {
                if (tire.getPressure() > 1) {
                    return false;
                }
            }
            return true;
        };

        Predicate<Car> flamable = e -> e.getCargo().getType().equals("flamable");
        Predicate<Car> engineOver250 = e -> e.getEngine().getPower() > 250;

        if ( criteria.equals("fragile")){
            cars.entrySet().stream().filter(e-> fragile.test(e.getValue()))
                    .filter(e-> tireUnderOne.test(e.getValue()))
                    .forEach(e-> e.getValue().printModel());
        } else {
            cars.entrySet().stream().filter(e-> flamable.test(e.getValue()))
                    .filter(e-> engineOver250.test(e.getValue()))
                    .forEach(e-> e.getValue().printModel());
        }
    }
}
