package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String type = sc.nextLine();

        while (!type.equals("Beast!")) {
            String[] input = sc.nextLine().split("\\s+");
            Animal animal = null;
            switch (type) {
                case "Cat":
                    try {
                        animal = new Cat(input[0], Integer.parseInt(input[1]), input[2]);
                    } catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Dog":
                    try {
                        animal = new Dog(input[0], Integer.parseInt(input[1]), input[2]);
                    } catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Frog":
                    try {
                        animal = new Frog(input[0], Integer.parseInt(input[1]), input[2]);
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Kitten":
                    try {
                        animal = new Kitten(input[0], Integer.parseInt(input[1]));
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Tomcat":
                    try {
                        animal = new Tomcat(input[0], Integer.parseInt(input[1]));
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid input!");
            }
            if (animal != null) animals.add(animal);
            type = sc.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
