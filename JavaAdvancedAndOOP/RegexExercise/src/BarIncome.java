import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BarIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern regex = Pattern.compile("%(?<name>[A-Z][a-z]+)%[^%.$|]*<(?<product>\\w+)>[^%.$|]*\\|(?<count>\\d+)\\|");
        Pattern pricereg = Pattern.compile("(\\d+.?\\d*)\\$");
        double sum  = 0;
        String input = sc.nextLine();
        while (!input.equals("end of shift")){
            Matcher matcher = regex.matcher(input);
            Matcher priceMatcher = pricereg.matcher(input);
            if (matcher.find() && priceMatcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(priceMatcher.group(1));
                System.out.printf("%s: %s - %.2f%n",name,product,count*price);
                sum += count*price;
            }
            input = sc.nextLine();
        }
        System.out.printf("Total income: %.2f%n",sum);
    }
}
