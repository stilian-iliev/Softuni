import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String names = sc.nextLine();

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(names);
        while (matcher.find()){
            System.out.print(matcher.group()+" ");
        }
    }
}
