import java.util.Scanner;

public class Palindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String palindrome = "";
        int palindromeLength = 0;
        int biggestPalindrome = 1;
        for (int i = 0; i < input.length(); i++) {
            int a = i;
            int b = i;
            if (a - 1 >= 0 && b + 1 < input.length()) {
                a--;
                b++;
                palindromeLength = 1;
                while (a >= 0 && b < input.length() && input.charAt(a) == input.charAt(b)) {
                    a--;
                    b++;
                    palindromeLength += 2;
                    if (palindromeLength > biggestPalindrome) {
                        biggestPalindrome = palindromeLength;
                    }
                }
            }
            a = i;
            b = i;
            if (b++ == input.length()) {
                continue;
            }
            palindromeLength = 0;
            while (a >= 0 && b < input.length() && input.charAt(a) == input.charAt(b)) {
                a--;
                b++;
                palindromeLength += 2;
                if (palindromeLength > biggestPalindrome) {
                    biggestPalindrome = palindromeLength;
                }
            }

        }
        System.out.println(biggestPalindrome);
    }
}
