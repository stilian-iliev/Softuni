import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        String[] command = sc.nextLine().split(">>>");
        while (!command[0].equals("Generate")){
            switch (command[0]){
                case "Contains":
                    String substring = command[1];
                    boolean containsSubstring = checkSubstring(key,substring);
                    if (containsSubstring){
                        System.out.printf("%s contains %s%n",key, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String direction = command[1];
                    int start = Integer.parseInt(command[2]);
                    int end = Integer.parseInt(command[3]);
                    String original = key.substring(start,end);
                    if (direction.equals("Upper")){
                        key = key.replace(original,original.toUpperCase());
                    } else if (direction.equals("Lower")){
                        key = key.replace(original,original.toLowerCase());
                    }
                    System.out.println(key);
                    break;
                case "Slice":
                    start = Integer.parseInt(command[1]);
                    end = Integer.parseInt(command[2]);
                    substring = key.substring(start,end);
                    key = key.replace(substring,"");
                    System.out.println(key);
                    break;
            }
            command = sc.nextLine().split(">>>");
        }
        System.out.printf("Your activation key is: %s%n",key);
    }

    private static boolean checkSubstring(String key, String substring) {
        return key.contains(substring);
    }
}
