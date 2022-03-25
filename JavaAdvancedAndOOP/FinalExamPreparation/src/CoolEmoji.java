import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoolEmoji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        long threshold = 1;
        Pattern digits = Pattern.compile("[0-9]");
        Matcher digitMatcher = digits.matcher(text);
        while (digitMatcher.find()) {
            threshold *= Integer.parseInt(digitMatcher.group());
        }
        Pattern emojiPattern = Pattern.compile("([\\*:])\\1(?<emoji>[A-Z][a-z]{2,})\\1\\1");
        Matcher emojiMatcher = emojiPattern.matcher(text);
        List<String> coolEmojis = new ArrayList<>();
        int emojiCount = 0;
        while (emojiMatcher.find()) {
            emojiCount++;
            String emoji = emojiMatcher.group("emoji");
            int emojiCoolness = 0;
            for (int i = 0; i < emoji.length(); i++) {
                emojiCoolness += emoji.charAt(i);
            }
            if (emojiCoolness>=threshold) {
                coolEmojis.add(emojiMatcher.group());
            }
        }
        System.out.printf("Cool threshold: %d%n", threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCount);
        for (String coolEmoji : coolEmojis) {
            System.out.println(coolEmoji);
        }
    }
}
