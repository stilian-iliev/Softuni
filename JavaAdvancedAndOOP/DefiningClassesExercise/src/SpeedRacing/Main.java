package SpeedRacing;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String,Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0){
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            int fuelAmount = Integer.parseInt(input[1]);
            double fuelConsumption = Double.parseDouble(input[2]);

            cars.put(model,new Car(model,fuelAmount,fuelConsumption));
        }

        String[] input = sc.nextLine().split("\\s+");
        while (!input[0].equals("End")){
            String model = input[1];
            int travelDistance = Integer.parseInt(input[2]);
            if (!cars.get(model).drive(travelDistance)){
                System.out.println("Insufficient fuel for the drive");
            }

            input = sc.nextLine().split("\\s+");
        }
        cars.values()
                .forEach(e-> System.out.println(e.toString()));
    }
}
