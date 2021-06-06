import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Function<int[],Integer> min = e -> Arrays.stream(e).min().orElse(0);

        int[] numbers = Arrays.stream(sc.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(min.apply(numbers));
    }
}
