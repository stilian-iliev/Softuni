import java.util.Collections;
import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder message = new StringBuilder(sc.nextLine());
        String[] command = sc.nextLine().split(":\\|:");
        while (!command[0].equals("Reveal")){
            switch (command[0]){
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);
                    message.insert(index," ");
                    System.out.println(message.toString());
                    break;
                case "Reverse":
                    StringBuilder substring= new StringBuilder(command[1]);
                    StringBuilder substringReversed= new StringBuilder(substring).reverse();
                    if (message.toString().contains(substring)){
                        message = new StringBuilder(message.toString().replace(substring,"")).append(substringReversed);
                        System.out.println(message.toString());
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substringg = command[1];
                    String replacement = command[2];
                    message = new StringBuilder(message.toString().replace(substringg,replacement));
                    System.out.println(message.toString());
                    break;
            }
            command = sc.nextLine().split(":\\|:");
        }
        System.out.println("You have a new text message: " + message.toString());
    }
}
