import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class changeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = sc.nextLine().split("\\s+");
        while (!command[0].equals("end")){
            switch (command[0]){
                case "Delete":
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.remove(Integer.valueOf(command[1]));
                    }
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(command[2]), Integer.valueOf(command[1]));
                    break;
            }
            command = sc.nextLine().split("\\s+");
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
