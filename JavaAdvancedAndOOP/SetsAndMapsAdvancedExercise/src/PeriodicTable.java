import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<String> elements = new TreeSet<>();

        int n = Integer.parseInt(sc.nextLine());
        while (n-- >0){
            String[] input = sc.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(input));
        }

        elements.forEach(e -> System.out.print(e + " "));
    }
}
