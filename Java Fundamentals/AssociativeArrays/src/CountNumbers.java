import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> counter = new TreeMap<>();
        for (double number : numbers) {
            if(!counter.containsKey(number)){
                counter.put(number, 1);
            } else {
                int currentCount = counter.get(number);
                currentCount++;
                counter.put(number,currentCount);
            }

        }
        DecimalFormat df = new DecimalFormat("#.####");
        for (Map.Entry<Double, Integer> set : counter.entrySet()) {
            System.out.printf("%s -> %d%n", df.format(set.getKey()) ,set.getValue());
        }
    }
}
