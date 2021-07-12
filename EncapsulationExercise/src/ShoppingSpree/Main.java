package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] peopleInput = sc.nextLine().split(";");

        List<Person> people = new ArrayList<>();

        for (String s : peopleInput) {
            String name = s.split("=")[0];
            double money = Double.parseDouble(s.split("=")[1]);

            try {
                Person person = new Person(name, money);
                people.add(person);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String[] productInput = sc.nextLine().split(";");

        List<Product> products = new ArrayList<>();

        for (String s : productInput) {
            String name = s.split("=")[0];
            double price = Double.parseDouble(s.split("=")[1]);

            Product product = new Product(name, price);
            products.add(product);
        }

        String input = sc.nextLine();

        while (!input.equals("END")) {
            String personName = input.split("\\s+")[0];
            String productName = input.split("\\s+")[1];


            Product product = products.stream().filter(e -> e.getName().equals(productName)).findFirst().orElse(null);

            if (product != null)
                people.stream().filter(e -> e.getName().equals(personName)).forEach(e -> e.buyProduct(product));


            input = sc.nextLine();
        }

        for (Person person : people) {
            if (person.cart().size() == 0){
                System.out.println(person.getName() + " - Nothing bought");
            } else {
                System.out.printf("%s - %s%n", person.getName(), person.cart().stream().map(Product::getName).collect(Collectors.joining(", ")));
            }
        }
    }
}
