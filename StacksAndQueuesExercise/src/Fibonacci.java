import java.util.Scanner;

public class Fibonacci {
    public static long[] memory;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        memory = new long[n + 1];
        System.out.println(fib(n));
    }

    private static long fib(int n) {
        if (n <= 1) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        return memory[n] = fib(n-1) +fib(n-2);
    }
}
