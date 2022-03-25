import java.util.Locale;
import java.util.Scanner;

public class extra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder key = new StringBuilder(sc.nextLine());
        String[] command = sc.nextLine().split(">>>");
        while (!command[0].equals("Generate")){
            String act = command[0];
            switch (act){
                case "Contains":
                    String substring = command[1];
                    if (key.toString().contains(substring)){
                        System.out.printf("%s contains %s%n",key, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String stringCase = command[1];
                    int start = Integer.parseInt(command[2]);
                    int end = Integer.parseInt(command[3]);
                    switch (stringCase){
                        //might have to add one to the end index
                        case "Lower":
                            String sub = key.substring(start,end);
                            key = key.replace(start,end, sub.toLowerCase());
                            System.out.println(key);
                            break;
                        case "Upper":
                            String sub1 = key.substring(start,end);
                            key = key.replace(start,end, key.substring(start,end).toUpperCase());
                            System.out.println(key);
                            break;
                    }
                    break;
                case "Slice":
                    int start1 = Integer.parseInt(command[1]);
                    int end1 = Integer.parseInt(command[2]);
                    key = key.replace(start1,end1,"");
                    System.out.println(key);
                    break;
            }
            command= sc.nextLine().split(">>>");
        }
        System.out.printf("Your activation key is: %s",key);
    }
}
