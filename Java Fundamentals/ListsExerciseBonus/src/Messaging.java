import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        StringBuilder text = new StringBuilder();
        text.append(sc.nextLine());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numbersList.size(); i++) {
            int current = findCurrentChar(text,numbersList,i);
            output.append(text.charAt(current));
            text = text.deleteCharAt(current);
        }
        System.out.println(output.toString());
    }

    private static int findCurrentChar(StringBuilder text, List<Integer> numbersList, int i) {
        int currentInt = numbersList.get(i);
        int sum = 0;
        while (currentInt!=0){
            sum += currentInt%10;
            currentInt/=10;
        }
        while (text.length()<sum){
            sum -= text.length();
        }
        return sum;
    }
}
