import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CharCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != ' '){
                charCount.putIfAbsent(input.charAt(i),0);
                charCount.put(input.charAt(i), charCount.get(input.charAt(i))+1);
            }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : charCount.entrySet()) {
            System.out.printf("%s -> %s%n",characterIntegerEntry.getKey(), characterIntegerEntry.getValue());
        }
    }
}
