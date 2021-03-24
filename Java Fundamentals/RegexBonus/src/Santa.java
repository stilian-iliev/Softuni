import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Santa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> children = new ArrayList<>();
        int key = Integer.parseInt(sc.nextLine());
        String message = sc.nextLine();
        while (!message.equals("end")){
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                decrypted.append((char)(message.charAt(i)-key));
            }
            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]+?!(?<beh>[GN])!");
            Matcher matcher = pattern.matcher(decrypted.toString());
            if(matcher.find()){
                String name = matcher.group("name");
                String beh = matcher.group("beh");
                if (beh.equals("G")){
                    children.add(name);
                }
            }
            message = sc.nextLine();
        }
        for (String child : children) {
            System.out.println(child);
        }
    }
}
