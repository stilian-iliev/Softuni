import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dates = sc.nextLine();
        Pattern regex = Pattern.compile("(?<day>\\d{2})([\\.\\-\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})");
        Matcher matcher = regex.matcher(dates);
        while (matcher.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n",matcher.group("day"),matcher.group("month"),matcher.group("year"));
        }
    }
}
