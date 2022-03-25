import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<Integer> first = new LinkedHashSet<>();
        LinkedHashSet<Integer> second = new LinkedHashSet<>();

        int[] mAndN = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = mAndN[0];
        int m = mAndN[1];

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(sc.nextLine());
            first.add(input);
        }
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(sc.nextLine());
            second.add(input);
        }
        first.retainAll(second);

        for (Integer integer : first) {
            System.out.print(integer + " ");
        }
    }
}
