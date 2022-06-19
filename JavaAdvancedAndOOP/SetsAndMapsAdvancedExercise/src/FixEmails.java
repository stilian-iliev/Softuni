import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, String> emailList = new LinkedHashMap<>();
        String name = sc.nextLine();
        while (!name.equals("stop")) {
            String email = sc.nextLine();
            String domain = email.split("\\.")[email.split("\\.").length - 1].toLowerCase(Locale.ROOT);
            switch (domain) {
                case "us":
                case "uk":
                case "com":
                    break;
                default:
                    emailList.put(name, email);
                    break;
            }
            name = sc.nextLine();
        }
        for (Map.Entry<String, String> entry : emailList.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
