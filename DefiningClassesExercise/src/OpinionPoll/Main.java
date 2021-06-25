package OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- >0){
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            people.add(new Person(name,age));
        }

        people.stream().filter(e-> e.getAge() >30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(e-> System.out.println(e.toString()));
    }
}
