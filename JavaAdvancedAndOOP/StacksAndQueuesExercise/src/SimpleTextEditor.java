import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder text = new StringBuilder("");
        ArrayDeque<String> history = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int command = Integer.parseInt(input[0]);

            switch (command) {
                case 1:
                    text.append(input[1]);
                    history.push(text.toString());
                    break;
                case 2:
                    int command2 = Integer.parseInt(input[1]);
                    text = new StringBuilder(text.substring(0, text.length() - command2));
                    history.push(text.toString());
                    break;
                case 3:
                    command2 = Integer.parseInt(input[1]);
                    System.out.println(history.peek().charAt(command2 - 1));
                    break;
                case 4:
                    history.pop();
                    if (!history.isEmpty())
                    text = new StringBuilder(history.peek());
                    break;
            }
        }
    }
}
