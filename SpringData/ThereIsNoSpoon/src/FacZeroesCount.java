import java.math.BigInteger;

public class FacZeroesCount {
    public static int zeros(int n) {
        // your beautiful code here
        BigInteger fac = new BigInteger(String.valueOf(n));
        while (n > 1) {
            fac = fac.multiply(BigInteger.valueOf((n-1)));

            n--;
        }
        int zeroCount = 0;
        while (!fac.equals(BigInteger.valueOf(0)) && String.valueOf(fac).charAt(String.valueOf(fac).length() -1) == '0') {
            zeroCount++;

            fac = fac.divide(BigInteger.valueOf(10));
        }
        return zeroCount;
    }
}
