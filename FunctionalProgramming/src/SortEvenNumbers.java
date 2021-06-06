import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> input = Arrays.asList(sc.nextLine().split(", "));
        int[] numbers = input
                .stream()
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();

        Function<int[], String> print = arr -> Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(print.apply(numbers));

        numbers = Arrays.stream(numbers)
                .sorted()
                .toArray();

        System.out.println(print.apply(numbers));

    }
}
