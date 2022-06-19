import java.util.Scanner;

public class ImitationGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        String[] command = sc.nextLine().split("\\|");
        while (!command[0].equals("Decode")) {
            switch (command[0]) {
                case "Move":
                    int n = Integer.parseInt(command[1]);
                    String substring = message.substring(0,n);
                    message = message.substring(n).concat(substring);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[1]);
                    String value = command[2];
                    StringBuilder temp = new StringBuilder(message);
                    temp.insert(index,value);
                    message = temp.toString();
                    break;
                case "ChangeAll":
                    substring = command[1];
                    String replacement = command[2];
                    message = message.replace(substring,replacement);
                    break;
            }
            command = sc.nextLine().split("\\|");
        }
        System.out.println("The decrypted message is: "+message);
    }
}
