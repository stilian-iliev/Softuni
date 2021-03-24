import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] usernames = sc.nextLine().split(", ");
        for (String username : usernames) {
            boolean valid = true;
            if (username.length()>=3 && username.length()<=16){
                for (int i = 0; i < username.length(); i++) {
                    char current = username.charAt(i);
                    if(Character.isDigit(current)|| Character.isAlphabetic(current) || current == '-'|| current == '_'){

                    } else {
                        valid = false;
                    }
                }
            } else {
                valid = false;
            }
            if (valid){
                System.out.println(username);
            }
        }
    }
}
