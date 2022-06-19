import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equals("end")) {
            StringBuilder output = new StringBuilder();
            for (int i = input.length() - 1; i >= 0; i--) {
                output.append(input.charAt(i));
            }
            System.out.println(input + " = " +output.toString());
            input = sc.nextLine();
        }
    }
}
