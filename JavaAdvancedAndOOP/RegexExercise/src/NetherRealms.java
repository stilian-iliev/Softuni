import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern health = Pattern.compile("[^\\d\\.\\+\\-\\*\\/\\s]");
        Pattern damage = Pattern.compile("[\\-\\+]?[\\d]+[\\.]?[\\d]*");
        List<String > names = Arrays.asList(sc.nextLine().split("\\s*,\\s*"));
        Collections.sort(names);
        for (String name : names) {
            int hp = 0;
            double dmg = 0;
            Matcher hpMatcher = health.matcher(name);
            Matcher dmgMatcher = damage.matcher(name);
            while (hpMatcher.find()){
                hp += hpMatcher.group().charAt(0);
            }
            while (dmgMatcher.find()){
                dmg += Double.parseDouble(dmgMatcher.group());
            }
            for (int i = 0; i < name.length(); i++) {
                char curr = name.charAt(i);
                if (curr == '*') dmg *= 2;
                else if (curr == '/') dmg /= 2;
            }
            System.out.printf("%s - %d health, %.2f damage%n",name,hp,dmg);
        }
    }
}
