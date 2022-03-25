import java.util.Arrays;

public class WordScore {
    public static String high(String s) {
        // Your code here...
        String[] words = s.split("\\s+");
        String highestString = "";
        int highestVal = 0;
        for (String word : words) {
            int currentVal = 0;
            for (char c : word.toCharArray()) {
                currentVal += c - 96;
            }
            if (currentVal > highestVal) {
                highestVal = currentVal;
                highestString = word;
            }
        }
        return highestString;
    }
}
