package SmartArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SmartArray array = new SmartArray();
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        array.add(5,5);
        array.forEach(System.out::println);

    }
}
