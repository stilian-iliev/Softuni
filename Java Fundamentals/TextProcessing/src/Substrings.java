import java.util.Scanner;

public class Substrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        String text = sc.nextLine();
        while (text.contains(key)){
            text = text.replace(key,"");
        }
        System.out.println(text);
    }
}
