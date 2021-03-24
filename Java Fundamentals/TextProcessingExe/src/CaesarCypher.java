import java.util.Scanner;

public class CaesarCypher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char curr = (char) (input.charAt(i)+3);
            output.append(curr);
        }
        System.out.println(output.toString());
    }
}
