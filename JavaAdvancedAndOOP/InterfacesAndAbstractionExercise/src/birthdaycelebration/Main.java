package birthdaycelebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Birthable> birthableList = new ArrayList<>();

        String input = sc.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            switch (tokens[0]){
                case "Citizen":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthdate = tokens[4];
                    birthableList.add(new Citizen(name,age,id,birthdate));
                    break;
                case "Pet":
                    name = tokens[1];
                    birthdate = tokens[2];
                    birthableList.add(new Pet(name, birthdate));
                    break;
                case "Robot":
                    break;
            }

            input = sc.nextLine();
        }
        String year = sc.nextLine();

        birthableList.stream().filter(e-> e.getBirthDate().split("/")[2].equals(year)).forEach(e-> System.out.println(e.getBirthDate()));
    }
}
