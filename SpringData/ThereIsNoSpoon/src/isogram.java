import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class isogram {
    public static boolean isIsogram(String str) {
        Set<String> out = new HashSet<>(Arrays.asList(str.toLowerCase().split("")));
        return str.length() == 0 || out.size() == str.length();
    }
}