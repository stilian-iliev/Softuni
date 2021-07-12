import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(threads::offer);

        int n = Integer.parseInt(sc.nextLine());

        int killer = 0;

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int thread = threads.peek();
            int task = tasks.peek();

            if (task == n){
                killer = thread;
                break;
            }

            if (thread >= task){
                threads.poll();
                tasks.pop();
            } else {
                threads.poll();
            }
        }

        System.out.printf("Thread with value %d killed task %d%n",killer,n);

        System.out.println(threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
