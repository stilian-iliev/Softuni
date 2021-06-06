import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = sc.nextLine();
        while (!input.equals("end")) {
            if (input.equals("print")) {
                print(numbers);
                input = sc.nextLine();
                continue;
            }
            Function<int[], int[]> apply = calculate(input);
            numbers = apply.apply(numbers);
            input = sc.nextLine();
        }
    }

    private static void print(int[] numbers) {
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static Function<int[], int[]> calculate(String input) {
        if (input.equals("add")) return e -> Arrays.stream(e).map(x -> x += 1).toArray();
        else if (input.equals("multiply")) return e -> Arrays.stream(e).map(x -> x = x * 2).toArray();
        else if (input.equals("subtract")) return e -> Arrays.stream(e).map(x -> x -= 1).toArray();
        else return e -> e;
    }
}
