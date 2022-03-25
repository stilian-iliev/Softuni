import java.util.*;

public class courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String[] input = sc.nextLine().split(" : ");
        while (!input[0].equals("end")) {
            String course = input[0];
            String name = input[1];
            courses.putIfAbsent(course, new ArrayList<>());
            courses.get(course).add(name);

            input = sc.nextLine().split(" : ");
        }
        courses.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(s -> System.out.printf("-- %s%n",s));
                });
    }
}
