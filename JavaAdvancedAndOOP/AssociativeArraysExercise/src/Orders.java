import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Double>> orders = new LinkedHashMap<>();
        String[] command = sc.nextLine().split(" ");
        while (!command[0].equals("buy")){
            String product = command[0];
            List<Double> priceNQuant = new ArrayList<>();
            priceNQuant.add(0.0);
            priceNQuant.add(0.0);
            orders.putIfAbsent(product,priceNQuant);

            orders.get(product).set(0,Double.parseDouble(command[1]));
            orders.get(product).set(1,orders.get(product).get(1) + Double.parseDouble(command[2]));

            command = sc.nextLine().split(" ");
        }
        for (Map.Entry<String, List<Double>> orderset : orders.entrySet()) {
            System.out.printf("%s -> %.2f%n",orderset.getKey(), orderset.getValue().get(0)*orderset.getValue().get(1));
        }
    }
}
