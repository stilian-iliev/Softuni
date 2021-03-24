import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        List<String> furnitures = new ArrayList<>();
        String input = sc.nextLine();
        while (!input.equals("Purchase")) {
            Pattern regex = Pattern.compile(">+(?<furniture>\\w+)<+(?<price>\\d+.?\\d*)!(?<quantity>\\d+)");
            Matcher matcher = regex.matcher(input);
            if (matcher.find()) {
                furnitures.add(matcher.group("furniture"));
                sum += Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
            }
            input = sc.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String furniture : furnitures) {
            System.out.println(furniture);
        }
        System.out.printf("Total money spend: %.2f", sum);
    }
}
