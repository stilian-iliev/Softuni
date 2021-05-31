import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<Double, Integer> list = new LinkedHashMap<>();

        double[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        for (double d : input) {
            list.putIfAbsent(d, 0);
            list.put(d,list.get(d)+1);
        }
        for (Map.Entry<Double, Integer> entry : list.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(), entry.getValue());
        }
    }
}
