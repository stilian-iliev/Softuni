import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] dividers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Predicate<Integer> dividable = e -> {

            for (int divider : dividers) {
                if (!(e%divider==0)) return false;
            }
            return true;
        };

        IntStream numbers = IntStream.rangeClosed(1, n);

        numbers.boxed()
                .filter(dividable)
                .forEach(x-> System.out.print(x+" "));
    }
}
