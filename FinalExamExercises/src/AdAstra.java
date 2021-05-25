import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Pattern pattern = Pattern.compile("([#\\|])(?<item>[A-Za-z\\s]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]+)\\1");
        Matcher matcher = pattern.matcher(text);
        int calories = 0;
        while (matcher.find()){
            int curr = Integer.parseInt(matcher.group("calories"));
            calories +=curr;
        }
        System.out.printf("You have food to last you for: %d days!%n",calories/2000);
        matcher = pattern.matcher(text);
        while (matcher.find()){
            String item = matcher.group("item");
            String expiration = matcher.group("date");
            String nutrition = matcher.group("calories");
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n",item,expiration,nutrition);
        }
    }
}
