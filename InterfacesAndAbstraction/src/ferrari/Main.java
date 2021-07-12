package ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String driverName = sc.nextLine();

        Ferrari ferrari = new Ferrari(driverName);

        System.out.printf("%s/%s/%s/%s%n", ferrari.getModel(), ferrari.brakes(), ferrari.gas(), ferrari.getDriverName());
    }
}
