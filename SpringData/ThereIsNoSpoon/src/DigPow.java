import java.util.Stack;

public class DigPow {

    public static long digPow(int n, int p) {
        int start = n;
        int end = 0;
        Stack<Integer> integers = new Stack<>();

        while (n != 0) {
            integers.push(n % 10);
            n /= 10;
        }
        while (integers.size() != 0) {
            end += Math.pow(integers.pop(), p);
            p++;
        }
        if (end%start == 0) {
            return end/start;
        }
        return -1;
    }

}