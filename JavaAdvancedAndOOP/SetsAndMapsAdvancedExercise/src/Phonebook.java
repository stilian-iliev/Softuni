import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String,String> phonebook = new HashMap<>();

        String[] contacts = sc.nextLine().split("-");
        while (!contacts[0].equals("search")){
            phonebook.put(contacts[0],contacts[1]);
            contacts = sc.nextLine().split("-");
        }
        String search = sc.nextLine();
        while (!search.equals("stop")){
            if (phonebook.containsKey(search)){
                System.out.printf("%s -> %s%n",search,phonebook.get(search));
            } else {
                System.out.printf("Contact %s does not exist.%n",search);
            }
            search = sc.nextLine();
        }
    }
}
