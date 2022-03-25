import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String command = sc.nextLine();
        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (history.size() <= 1) {
                    System.out.println("no previous URLs");
                    command = sc.nextLine();
                    continue;
                } else {
                    queue.push(history.pop());
                    System.out.println(history.peek());
                }
            } else if (command.equals("forward")) {
                if (queue.peek() == null) System.out.println("no next URLs");
                else {
                    history.push(queue.peek());
                    System.out.println(queue.pop());
                }
            } else {
                history.push(command);
                System.out.println(history.peek());
                queue.clear();
            }

            command = sc.nextLine();
        }
    }
}
