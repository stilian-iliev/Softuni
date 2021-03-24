import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> numbersList = Arrays.stream(sc.nextLine().split("\\|+")).collect(Collectors.toList());
        Collections.reverse(numbersList);
        for (int i = 0; i < numbersList.size(); i++) {
            List<String> numbers = Arrays.stream(numbersList.get(i).split("\\s+")).collect(Collectors.toList());
            for (String number : numbers) {
                System.out.print(number + " ");
            }
        }
    }
}
