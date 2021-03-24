import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger bigNumber = new BigInteger(sc.nextLine());
        BigInteger multiplier = new BigInteger(sc.nextLine());

        bigNumber = bigNumber.multiply(multiplier);
        System.out.println(bigNumber);


    }
}
