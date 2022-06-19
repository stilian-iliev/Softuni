package CustomList;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomList<String> list = new CustomList<String>();

        String input = sc.nextLine();
        while (!input.equals("END")){
            switch (input.split("\\s+")[0]){
                case "Add":
                    String element = input.split("\\s+")[1];
                    list.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    element = input.split("\\s+")[1];
                    System.out.println(list.contains(element));
                    break;
                case "Swap":
                    int first = Integer.parseInt(input.split("\\s+")[1]);
                    int second = Integer.parseInt(input.split("\\s+")[2]);
                    list.swap(first,second);
                    break;
                case "Greater":
                    element = input.split("\\s+")[1];
                    System.out.println(list.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.forEach(System.out::println);
                    break;
                case "Sort":
                    list.sort();
            }
            input = sc.nextLine();
        }
    }
}
