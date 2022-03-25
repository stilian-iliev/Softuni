package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String subj = tokens[1];
            people.putIfAbsent(name, new Person(name));

            switch (subj) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    people.get(name).setCompany(new Company(companyName,department,salary));
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    people.get(name).addPokemon(new Pokemon(pokemonName,pokemonType));
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    people.get(name).addParent(new Parent(parentName,parentBirthday));
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    people.get(name).addChild(new Child(childName,childBirthday));
                    break;
                case "car":
                    String model = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    people.get(name).setCar(new Car(model,speed));
                    break;
            }

            input = sc.nextLine();
        }
        String check = sc.nextLine();
        System.out.println(people.get(check).toString());
    }
}
