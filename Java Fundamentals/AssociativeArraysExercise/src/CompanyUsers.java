import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" -> ");
        Map<String, List<String>> companies = new TreeMap<>();
        while (!input[0].equals("End")) {
            String company = input[0];
            String id = input[1];
            companies.putIfAbsent(company, new ArrayList<>());
            if (!companies.get(company).contains(id)) {
                companies.get(company).add(id);
            }
            input = sc.nextLine().split(" -> ");
        }
        companies.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.forEach(id -> System.out.printf("-- %s%n", id));
        });
    }
}
