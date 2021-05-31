import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String,Map<String,Double>> shops = new TreeMap<>();

        String input = sc.nextLine();
        while (!input.equals("Revision")){
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            shops.putIfAbsent(shop,new LinkedHashMap<>());
            shops.get(shop).put(product,price);

            input = sc.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> shop : shops.entrySet()) {
            System.out.println(shop.getKey()+ "->");
            for (Map.Entry<String, Double> products : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",products.getKey(), products.getValue());
            }

        }
    }
}
