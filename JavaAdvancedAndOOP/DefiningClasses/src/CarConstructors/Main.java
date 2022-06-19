package CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            String make;
            String model = "unknown";
            int hp = -1;
            if (input.length == 1) {
                make = input[0];
            } else {
                make = input[0];
                model = input[1];
                hp = Integer.parseInt(input[2]);
            }
            Car car = new Car(make, model, hp);
            System.out.println(car.toString());
        }
    }
}
