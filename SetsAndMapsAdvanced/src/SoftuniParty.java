import java.util.Scanner;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<String> guests = new TreeSet<>();

        String list = sc.nextLine();
        while (!list.equals("PARTY")){
            guests.add(list);
            list = sc.nextLine();
        }
        String attend = sc.nextLine();
        while (!attend.equals("END")){
            guests.remove(attend);
            attend = sc.nextLine();
        }
        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
