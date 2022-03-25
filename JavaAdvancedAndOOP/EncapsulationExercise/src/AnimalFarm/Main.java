package AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        Chicken chicken;
        try {
            chicken = new Chicken(name, age);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(chicken.toString());
    }
}
