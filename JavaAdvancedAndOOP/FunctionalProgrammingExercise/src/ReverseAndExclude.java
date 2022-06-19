import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        int n = Integer.parseInt(sc.nextLine());
        numbers.removeIf(x->x%n==0);

        Collections.reverse(numbers);
        numbers.forEach(x-> System.out.print(x +" "));
    }
}
