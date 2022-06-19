import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Function<Double, Double> addVAT = x -> x * 1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(sc.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .forEach(e-> System.out.printf("%.2f%n",addVAT.apply(e)));
    }
}
