import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> symbols = new TreeMap<>();

        String[] input = sc.nextLine().split("");
        for (String s : input) {
            symbols.putIfAbsent(s,0);
            symbols.put(s,symbols.get(s)+1);
        }
        for (Map.Entry<String, Integer> entry : symbols.entrySet()) {
            System.out.printf("%s: %d time/s%n",entry.getKey(),entry.getValue());
        }
    }
}
