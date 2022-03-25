import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Consumer<String> printKnight = e -> System.out.println("Sir " + e);

        Arrays.stream(sc.nextLine().split("\\s+")).forEach(printKnight);
    }
}
