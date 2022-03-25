import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuitt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Pattern pattern = Pattern.compile("(?<string>[^\\d]+)(?<digit>\\d+)");
        Matcher matcher = pattern.matcher(input);
        StringBuilder output = new StringBuilder();
        while (matcher.find()){
            String string = matcher.group("string");
            int digit = Integer.parseInt(matcher.group("digit"));
            for (int i = 0; i < digit; i++) {
                output.append(string.toUpperCase(Locale.ROOT));
            }
        }
        System.out.printf("Unique symbols used: %d%n",output.chars().distinct().count());
        System.out.println(output.toString());
    }
}
