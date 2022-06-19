import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParantheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");
        ArrayDeque<String> firstHalf = new ArrayDeque<>();
        boolean balanced = false;
        for (int i = 0; i < input.length; i++) {
            if (i < input.length / 2) {
                firstHalf.push(input[i]);
            } else {
                if ((input[i].equals(")") && firstHalf.peek().equals("(")) || (input[i].equals("(") && firstHalf.peek().equals(")"))) {
                    firstHalf.pop();
                    balanced = true;
                } else if ((input[i].equals("[") && firstHalf.peek().equals("]")) || (input[i].equals("]") && firstHalf.peek().equals("["))) {
                    firstHalf.pop();
                    balanced = true;
                } else if ((input[i].equals("}") && firstHalf.peek().equals("{")) || (input[i].equals("{") && firstHalf.peek().equals("}"))){
                    firstHalf.pop();
                    balanced = true;
                } else {
                    balanced = false;
                }
            }
        }
        if (balanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
