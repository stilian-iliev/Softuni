package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Engine> engines = new ArrayList<>();

        while (n-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            switch (input.length) {
                case 2:
                    engines.add(new Engine(input[0], Integer.parseInt(input[1])));
                    break;
                case 3:
                    if (isDigit(input[2])) {
                        engines.add(new Engine(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                    } else {
                        engines.add(new Engine(input[0], Integer.parseInt(input[1]), input[2]));
                    }
                    break;
                case 4:
                    engines.add(new Engine(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), input[3]));
                    break;
            }
        }

        int m = Integer.parseInt(sc.nextLine());

        List<Car> cars = new ArrayList<>();

        while (m-- > 0){
            String[] input = sc.nextLine().split("\\s+");
            switch (input.length){
                case 2:
                    cars.add(new Car(input[0], putEngine(engines,input[1])));
                    break;
                case 3:
                    if (isDigit(input[2])){
                        cars.add(new Car(input[0], putEngine(engines,input[1]), Integer.parseInt(input[2])));
                    } else {
                        cars.add(new Car(input[0], putEngine(engines,input[1]), input[2]));
                    }
                    break;
                case 4:
                    cars.add(new Car(input[0], putEngine(engines,input[1]), Integer.parseInt(input[2]),input[3]));
                    break;
            }
        }
        cars.forEach(e-> System.out.print(e.toString()));
    }

    private static Engine putEngine(List<Engine> engines, String s) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(s)){
                return engine;
            }
        }
        return null;
    }

    private static boolean isDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }
}
