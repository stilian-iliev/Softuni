package FlowerWreaths;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(lilies::push);

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(roses::offer);
        int flowers = 0;
        int wreath = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int sum = lilies.peek() + roses.peek();

            if (sum > 15) {
                lilies.push(lilies.pop() - 2);
            } else if (sum < 15) {
                lilies.pop();
                roses.pop();
                flowers += sum;
            } else {
                lilies.pop();
                roses.pop();
                wreath++;
            }
        }
        wreath += flowers / 15;

        if (wreath>=5) System.out.printf("You made it, you are going to the competition with %d wreaths!%n",wreath);
        else System.out.printf("You didn't make it, you need %d wreaths more!%n",5-wreath);
    }
}
