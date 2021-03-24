import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        StringBuilder output = new StringBuilder();
        for (String word : input) {
            output.append(word.repeat(word.length()));
        }
        System.out.println(output.toString());
    }
}
