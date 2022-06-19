import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> chest = Arrays.asList(sc.nextLine().split("|").clone());
        String[] input = sc.nextLine().split(" ");
        chest.add("works?");
        for (String s : chest) {
            System.out.println(s);
        }
    }
}
