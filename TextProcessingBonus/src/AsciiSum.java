import java.util.Scanner;

public class AsciiSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char firstChar = sc.nextLine().charAt(0);
        char secondChar = sc.nextLine().charAt(0);
        String idk = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < idk.length(); i++) {
            char curr = idk.charAt(i);
            if(curr > firstChar && curr < secondChar){
                sum+=curr;
            }
        }
        System.out.println(sum);
    }
}

