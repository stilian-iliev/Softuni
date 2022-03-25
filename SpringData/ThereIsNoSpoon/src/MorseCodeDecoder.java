import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        String[] words = null;
        StringBuilder sb = new StringBuilder();
        if (morseCode.contains("   ")) {
            words = morseCode.split("   ");
        } else {
            words = new String[]{morseCode};
        }

        for (String word : words) {
            Arrays.stream(word.split(" ")).map(MorseCodeDecoder::decodeLetter).forEach(sb::append);
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static String decodeLetter(String morseCode) {
        Map<String, String> alphabet = new HashMap<>();
        
        alphabet.put(".-" , "A");
        alphabet.put("-...", "B");
        alphabet.put("-.-.", "C");
        alphabet.put("-..", "D");
        alphabet.put(".", "E");
        alphabet.put("..-.", "F");
        alphabet.put("--.", "G");
        alphabet.put("....", "H");
        alphabet.put("..", "I");
        alphabet.put(".---", "J");
        alphabet.put("-.-", "K");
        alphabet.put(".-..", "L");
        alphabet.put("--", "M");
        alphabet.put("-.", "N");
        alphabet.put("---", "O");
        alphabet.put(".--.", "P");
        alphabet.put("--.-", "Q");
        alphabet.put(".-.", "R");
        alphabet.put("...", "S");
        alphabet.put("-", "T");
        alphabet.put("..-", "U");
        alphabet.put("...-", "V");
        alphabet.put(".--", "W");
        alphabet.put("-..-", "X");
        alphabet.put("-.--", "Y");
        alphabet.put("--..", "Z");

        alphabet.put(".----","1");
        alphabet.put("..---","2");
        alphabet.put("...--","3");
        alphabet.put("....-","4");
        alphabet.put(".....","5");
        alphabet.put("-....","6");
        alphabet.put("--...","7");
        alphabet.put("---..","8");
        alphabet.put("----.","9");
        alphabet.put("-----","0");

        return alphabet.get(morseCode);
    }
}