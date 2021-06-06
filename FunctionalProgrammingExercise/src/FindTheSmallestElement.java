import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> findSmallestNumIndex = list -> {
            int min = Integer.MAX_VALUE;
            for (Integer integer : list) {
                if (integer < min) {
                    min = integer;
                }
            }
            System.out.println(numbers.lastIndexOf(min));
        };

        findSmallestNumIndex.accept(numbers);

    }
}
