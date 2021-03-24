import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] banList = sc.nextLine().split(", ");
        String text = sc.nextLine();
        for (int i = 0; i < banList.length; i++) {
            while (text.contains(banList[i])){
                String ast = "*";
                text = text.replace(banList[i], ast.repeat(banList[i].length()));
            }
        }
        System.out.println(text);
    }
}
