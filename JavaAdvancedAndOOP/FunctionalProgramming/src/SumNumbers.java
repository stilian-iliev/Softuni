import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[],Integer> count = arr -> Math.toIntExact(Arrays.stream(arr).count());
        Function<int[],Integer> sum = arr -> Arrays.stream(arr).sum();

        System.out.println("Count = "+ count.apply(numbers));
        System.out.println("Sum = "+ sum.apply(numbers));
    }
}
