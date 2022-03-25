import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            usernames.add(sc.nextLine());
        }
        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
