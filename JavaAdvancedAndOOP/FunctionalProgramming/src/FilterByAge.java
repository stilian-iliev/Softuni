import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] input = sc.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            people.put(name, age);
        }
        String condition = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        String toPrint = sc.nextLine();

        Predicate<Map.Entry<String, Integer>> test = tester(condition, age);

        Consumer<Map.Entry<String, Integer>> print = printer(toPrint);

        people.entrySet().stream()
                .filter(test)
                .forEach(print);
    }

    private static Consumer<Map.Entry<String, Integer>> printer(String toPrint) {
        if (toPrint.equals("name")) {
            return entry -> System.out.println(entry.getKey());
        } else if (toPrint.equals("age")) {
            return entry -> System.out.println(entry.getValue());
        } else {
            return entry -> System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static Predicate<Map.Entry<String, Integer>> tester(String condition, int age) {
        if (condition.equals("older")) return e -> e.getValue() >= age;
        else return e -> e.getValue() <= age;
    }
}
