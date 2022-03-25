import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] in = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String evenOrOdd = sc.nextLine();

        Predicate<Integer> test = tester(evenOrOdd);

        IntStream.rangeClosed(in[0], in[1])
                .boxed()
                .filter(test)
                .forEach(e -> System.out.printf("%d ", e));
    }

    private static Predicate<Integer> tester(String evenOrOdd) {
        if (evenOrOdd.equals("odd")) return e -> e % 2 == 1;
        else return e -> e % 2 == 0;
    }
}
