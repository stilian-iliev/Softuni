import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        Pattern star = Pattern.compile("[STARstar]");
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            StringBuilder text = new StringBuilder();
            int starCount = 0;
            Matcher matcher = star.matcher(input);
            while (matcher.find()) {
                starCount++;
            }
            for (int j = 0; j < input.length(); j++) {
                char curr = (char) (input.charAt(j) - starCount);
                text.append(curr);
            }
            Pattern decrypt = Pattern.compile("@(?<planetName>[A-Za-z]*)[^@\\-!:>]*:(?<population>[0-9]*)[^@\\-!:>]*!(?<action>[AD])![^@\\-!:>]*->(?<soliders>[0-9]*)");
            Matcher decrypter = decrypt.matcher(text.toString());
            if (decrypter.find()) {
                String planetName = decrypter.group("planetName");
                String action = decrypter.group("action");
                if (action.equals("A")) {
                    attacked.add(planetName);
                } else {
                    destroyed.add(planetName);
                }
            }
        }
        Collections.sort(destroyed);
        Collections.sort(attacked);
        System.out.printf("Attacked planets: %d%n", attacked.size());
        for (String a : attacked) {
            System.out.printf("-> %s%n",a);
        }
        System.out.printf("Destroyed planets: %d%n",destroyed.size());
        for (String d : destroyed) {
            System.out.printf("-> %s%n",d);
        }
    }
}
