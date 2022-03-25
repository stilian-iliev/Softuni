import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String command = sc.nextLine();
        while (!command.equals("Home")) {

            if (command.equals("back")){
                if (history.size()<=1){
                    System.out.println("no previous URLs");
                    command = sc.nextLine();
                    continue;
                } else {
                    history.pop();
                }
            } else {
                history.push(command);
            }

            System.out.println(history.peek());

            command = sc.nextLine();
        }
    }
}
