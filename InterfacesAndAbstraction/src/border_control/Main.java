package border_control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input = sc.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            switch (tokens.length){
                case 2:
                    identifiables.add(new Robot(tokens[0], tokens[1]));
                    break;
                case 3:
                    identifiables.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
                    break;
            }

            input = sc.nextLine();
        }
        String postfix = sc.nextLine();

        identifiables.stream().map(Identifiable::getId).filter(e-> e.endsWith(postfix)).forEach(System.out::println);
    }
}
