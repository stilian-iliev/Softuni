import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = sc.nextLine().split("\\s+");
        while (!command[0].equals("End")) {
            switch (command[0]) {
                case "Add":
                    numbers.add(Integer.valueOf(command[1]));
                    break;
                case "Insert":
                    if (Integer.parseInt(command[2]) < numbers.size() && Integer.parseInt(command[2])>=0) {
                        numbers.add(Integer.parseInt(command[2]), Integer.valueOf(command[1]));
                    } else System.out.println("Invalid index");
                    break;
                case "Remove":
                    if (Integer.parseInt(command[1]) < numbers.size() && Integer.parseInt(command[1])>=0) {
                        numbers.remove(Integer.parseInt(command[1]));
                    } else System.out.println("Invalid index");
                    break;
                case "Shift":
                    switch (command[1]) {
                        case "left":
                            shiftLeft(numbers, command[2]);
                            break;
                        case "right":
                            shiftRight(numbers, command[2]);
                            break;
                    }
                    break;
            }
            command = sc.nextLine().split(" ");
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static void shiftRight(List<Integer> numbers, String s) {
        for (int i = 0; i < Integer.parseInt(s); i++) {
            numbers.add(0, numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }
    }

    private static void shiftLeft(List<Integer> numbers, String s) {
        for (int i = 0; i < Integer.parseInt(s); i++) {
            numbers.add(numbers.get(0));
            numbers.remove(0);
        }
    }
}
