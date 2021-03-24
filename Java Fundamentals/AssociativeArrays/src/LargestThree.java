import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1)).collect(Collectors.toList());
        for (int i = 0; i < 3; i++) {
            if (numbers.size()>i)System.out.print(numbers.get(i) + " ");

        }
    }
}
