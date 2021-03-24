import java.util.Scanner;

public class ReplaceRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder(sc.nextLine());
        for (int i = 0; i < input.length()-1; i++) {
            char curr = input.charAt(i);
            char next = input.charAt(i+1);
            if(curr == next){
                input.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(input.toString());
    }
}
