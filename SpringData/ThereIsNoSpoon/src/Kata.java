import java.util.Arrays;
import java.util.stream.IntStream;

public class Kata {

    public static int[] arrayDiff(int[] a, int[] b) {

        return Arrays.stream(a).filter(i -> Arrays.stream(b).noneMatch(x-> x == i)).toArray();
    }

}