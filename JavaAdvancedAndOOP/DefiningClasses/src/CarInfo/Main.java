package CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        while (n-- >0){
            String[] input = sc.nextLine().split("\\s+");
            String make = input[0];
            String model = input[1];
            int hp = Integer.parseInt(input[2]);
            Car car = new Car(make, model, hp);
            System.out.println(car.toString());
        }
    }
}
