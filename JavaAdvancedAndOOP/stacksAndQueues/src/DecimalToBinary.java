import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimal = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();

        while (decimal != 0) {
            binary.push(decimal % 2);
            decimal /= 2;
        }
        for (Integer integer : binary) {
            System.out.print(integer);
        }
    }
}
