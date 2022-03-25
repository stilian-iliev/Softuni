import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("-");
        Map<String, Integer> submissions = new HashMap<>();
        Map<String, Integer> languages = new HashMap<>();
        while (!input[0].equals("exam finished")) {
            String username = input[0];
            String language = input[1];
            int points = 0;
            if (input.length == 3) {
                points = Integer.parseInt(input[2]);
            }
            switch (language) {
                case "banned":
                    submissions.remove(username);
                    break;
                default:
                    submissions.putIfAbsent(username, points);
                    if(submissions.get(username)<points){
                        submissions.put(username,points);
                    }
                    languages.putIfAbsent(language, 0);
                    languages.put(language, languages.get(language) + 1);
                    break;
            }

            input = sc.nextLine().split("-");
        }
        System.out.println("Results:");
        submissions.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(sub -> System.out.printf("%s | %d%n", sub.getKey(), sub.getValue()));
        System.out.println("Submissions:");
        languages.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(lang -> System.out.printf("%s - %d%n", lang.getKey(), lang.getValue()));
    }
}
