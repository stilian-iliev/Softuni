package ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListyIterator list = new ListyIterator();
        String[] strings = sc.nextLine().split("\\s+");
        List<String> temp = new ArrayList<>(Arrays.asList(strings).subList(1, strings.length));
        list.create(temp);

        String input = sc.nextLine();

        while (!input.equals("END")){
            switch (input){
                case "Move":
                    System.out.println(list.next());
                    break;
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;
                case "Print":
                    list.print();
                    break;
                case "PrintAll":
                    System.out.println(String.join(" ", list));
                    break;
            }

            input = sc.nextLine();
        }
    }
}
