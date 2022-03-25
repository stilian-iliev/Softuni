import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Pattern regex = Pattern.compile("[a-z][a-z\\-\\.]*[a-z]@[a-z]+[a-z][a-z\\-\\.]*\\.[a-z]+");
        Matcher matcher = regex.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
