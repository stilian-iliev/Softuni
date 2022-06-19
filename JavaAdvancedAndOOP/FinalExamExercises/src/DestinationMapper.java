import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        List<String> validDestinations = new ArrayList<>();
        Pattern pattern = Pattern.compile("([=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String destination = matcher.group("destination");
            validDestinations.add(destination);
        }
        int sum = 0;
        for (String validDestination : validDestinations) {
            sum += validDestination.length();
        }
        System.out.println("Destinations: " + String.join(", ",validDestinations));
        System.out.println("Travel Points: " + sum);
    }
}
