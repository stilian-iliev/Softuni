import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder text = new StringBuilder(sc.nextLine());
        String[] command = sc.nextLine().split(":");
        while (!command[0].equals("Travel")) {
            switch (command[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(command[1]);
                    String substring = command[2];
                    if (index < text.length() && index >= 0) {
                        text.insert(index, substring);
                    }
                    break;
                case "Remove Stop":
                    int start = Integer.parseInt(command[1]);
                    int end = Integer.parseInt(command[2]) ;
                    if (start >= 0 && start < text.length() && end >= 0 && end < text.length()) {
                        end++;
                        text.delete(start, end);
                    }
                    break;
                case "Switch":
                    String old = command[1];
                    String newString = command[2];
                    String textAsString = text.toString().replace(old, newString);
                    text = new StringBuilder(textAsString);
                    break;
            }
            System.out.println(text.toString());
            command = sc.nextLine().split(":");
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", text.toString());
    }
}