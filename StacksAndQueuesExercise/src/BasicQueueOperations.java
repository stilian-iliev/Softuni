import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] commands = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int toAdd = commands[0];
        int toPop = commands[1];
        int check = commands[2];

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < toAdd; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < toPop; i++) {
            queue.poll();
        }
        if (queue.contains(check)){
            System.out.println("true");
        }else if (queue.isEmpty()){
            System.out.println("0");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
