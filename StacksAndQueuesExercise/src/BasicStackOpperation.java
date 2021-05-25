import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOpperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] commands = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int toAdd = commands[0];
        int toPop = commands[1];
        int check = commands[2];

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < toAdd; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < toPop; i++) {
            stack.pop();
        }
        if (stack.contains(check)){
            System.out.println("true");
        } else if(stack.isEmpty()){
            System.out.println("0");
        } else {
            System.out.println(findSmallest(stack));
        }
    }

    private static int findSmallest(ArrayDeque<Integer> stack) {
        int smallest = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            if (integer<smallest){
                smallest = integer;
            }
        }
        return smallest;
    }
}
