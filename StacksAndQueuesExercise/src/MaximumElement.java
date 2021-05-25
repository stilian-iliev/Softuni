import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = sc.nextLine().split(" ");
            switch (command[0]) {
                case "1" -> stack.push(Integer.parseInt(command[1]));
                case "2" -> stack.pop();
                case "3" -> System.out.println(maximumElement(stack));
            }
        }
    }

    private static int maximumElement(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : stack) {
            if (integer>max) max = integer;
        }
        return max;
    }
}
