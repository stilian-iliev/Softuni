import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] command = sc.nextLine().split(" ");
            switch (command[2]){
                case "not":
                    if(names.contains(command[0])){
                        names.remove(command[0]);
                    }else System.out.printf("%s is not in the list!%n", command[0]);
                    break;
                default:
                    if(!names.contains(command[0])){
                        names.add(command[0]);
                    } else System.out.printf("%s is already in the list!%n", command[0]);
                    break;
            }
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
