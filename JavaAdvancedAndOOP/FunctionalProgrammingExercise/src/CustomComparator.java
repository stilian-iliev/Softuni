import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        List<Integer> even = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(x-> x%2==0)
                .sorted()
                .boxed()
                .collect(Collectors.toList());


        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(x-> x%2!=0)
                .sorted()
                .forEach(even::add);

        even.forEach(x-> System.out.print(x+" "));

    }
}
