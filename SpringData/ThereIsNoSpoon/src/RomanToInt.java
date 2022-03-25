import java.util.HashMap;

public class RomanToInt {
    public static int romanToInt(String s) {

        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        //xiv 5-1+10
        int integer = roman.get(s.charAt(s.length()-1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (roman.get(s.charAt(i)) >= roman.get(s.charAt(i + 1))) {
                integer += roman.get(s.charAt(i));
            } else {
                integer -= roman.get(s.charAt(i));
            }
        }
        return integer;
    }
}
