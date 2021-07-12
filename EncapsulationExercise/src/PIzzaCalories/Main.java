package PIzzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        Pizza pizza;
        try {
            pizza = new Pizza(input[1], Integer.parseInt(input[2]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        input = sc.nextLine().split("\\s+");

        Dough dough;

        try {
            dough = new Dough(input[1], input[2], Double.parseDouble(input[3]));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        pizza.setDough(dough);

        input = sc.nextLine().split("\\s+");

        while (!input[0].equals("END")){
            Topping topping;
            try {
                topping = new Topping(input[1], Double.parseDouble(input[2]));
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
            pizza.addTopping(topping);
            input = sc.nextLine().split("\\s+");
        }

        System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());

    }
}
