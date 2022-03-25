package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String command = scanner.nextLine();
        while (!command.equals("Exit")) {
            String[] input = command.split(" ");
            studentSystem.parseCommand(input);
            command = scanner.nextLine();
        }
    }
}
