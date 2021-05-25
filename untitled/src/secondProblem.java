import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class secondProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Pattern pattern = Pattern.compile("^([%$])(?<tag>[A-Z][a-z]{2,})\\1:\\s\\[(?<first>[0-9]+)]\\|\\[(?<second>[0-9]+)]\\|\\[(?<third>[0-9]+)]\\|$");
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String tag = matcher.group("tag");
                StringBuilder message = new StringBuilder();
                int first = Integer.parseInt(matcher.group("first"));
                int second = Integer.parseInt(matcher.group("second"));
                int third = Integer.parseInt(matcher.group("third"));
                message.append((char) first);
                message.append((char)second);
                message.append((char) third);
                System.out.printf("%s: %s%n",tag,message.toString());
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
