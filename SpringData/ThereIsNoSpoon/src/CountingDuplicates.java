import java.util.HashSet;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        HashSet<Character> unique = new HashSet<>();
        HashSet<Character> dupes = new HashSet<>();
        char[] split = text.toLowerCase().toCharArray();
        for (char c : split) {
            if (unique.contains(c)) {
                dupes.add(c);
            }
            unique.add(c);
        }
        return dupes.size();
    }
}