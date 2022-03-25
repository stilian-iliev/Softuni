import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split("\\s+");
        double sum = 0.0;
        for (int i = 0; i < inputs.length; i++) {
            String current = inputs[i];
            String start = String.valueOf(current.charAt(0));
            String end = String.valueOf(current.charAt(current.length() - 1));
            double number = Double.parseDouble(current.substring(1, current.length() - 1));
            if (start.equals(start.toUpperCase())) {
                number /= start.charAt(0) - 64;
            } else {
                number *= start.charAt(0) - 96;
            }
            if (end.equals(end.toUpperCase())) {
                number -= end.charAt(0) - 64;
            } else {
                number += end.charAt(0) - 96;
            }
            sum += number;
        }
        System.out.printf("%.2f", sum);
    }
}
