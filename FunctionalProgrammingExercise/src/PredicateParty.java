import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> people = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("Party!")) {
            String action = input.split("\\s+")[0];
            String criteria = input.split("\\s+")[1];
            String info = input.split("\\s+")[2];

            Predicate<String> test = tester(criteria, info);

            Function<List<String>, List<String>> remove = e ->{
                e.removeIf(test);
                return e;
            };
            Function<List<String>, List<String>> dub = e -> {
                List<String> b = new ArrayList<>();
                for (String name : e) {
                    if (test.test(name)){
                        b.add(name);
                    }
                    b.add(name);
                }
                return b;
            };

            if (action.equals("Remove")) {
                people = remove.apply(people);
            } else if (action.equals("Double")){
                people = dub.apply(people);
            }

            input = sc.nextLine();
        }
        Collections.sort(people);
        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!%n", String.join(", ",people));
        }
    }

    private static Predicate<String> tester(String criteria, String info) {
        if (criteria.equals("StartsWith")) return e -> e.startsWith(info);
        else if (criteria.equals("EndsWith")) return e -> e.endsWith(info);
        else return e -> e.length() == Integer.parseInt(info);
    }
}
