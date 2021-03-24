import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] keys = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String message = sc.nextLine();
        while (!message.equals("find")){
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0, n = 0; i < message.length(); i++,n++) {
                if(n==keys.length) n = 0;
                int keyAt = n;
                decrypted.append((char) (message.charAt(i)-keys[keyAt]));
            }
            String treasure = decrypted.substring(decrypted.indexOf("&")+1,decrypted.lastIndexOf("&"));
            String coordinates = decrypted.substring(decrypted.indexOf("<")+1,decrypted.indexOf(">"));
            System.out.printf("Found %s at %s%n",treasure,coordinates);
            message = sc.nextLine();
        }
    }
}
