import java.util.Locale;
import java.util.Scanner;

public class firstProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] command = sc.nextLine().split("\\s+");
        while (!command[0].equals("Done")){
            switch (command[0]){
                case "Change":
                    String sub = command[1];
                    String replacement = command[2];
                    text = text.replace(sub,replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    sub = command[1];
                    if (text.contains(sub)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    sub = command[1];
                    int length = sub.length();
                    String string = text.substring(text.length()-length);
                    if (string.equals(sub)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase(Locale.ROOT);
                    System.out.println(text);
                    break;
                case "FindIndex":
                    sub = command[1];
                    int a = text.indexOf(sub);
                    System.out.println(a);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    length = Integer.parseInt(command[2]);
                    text = text.substring(index,index+length);
                    System.out.println(text);
                    break;
            }
            command = sc.nextLine().split("\\s+");
        }
    }
}
