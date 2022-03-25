import java.util.ArrayList;
import java.util.List;

class SumDigPower {

    public static List<Long> sumDigPow(long a, long b) {
        // your code
        List<Long> match = new ArrayList<>();
        for (long i = a; i <= b; i++) {
            int sum = 0;
            int counter = 1;
            for (String c : String.valueOf(i).split("")) {
                sum += Math.pow(Integer.parseInt(c), counter++);
            }
            if (sum == i) {
                match.add(i);
            }
        }

        return match;
    }
}